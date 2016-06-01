package com.fujitsu.fs.javalab.bookshelf.web.controller;

import com.fujitsu.fs.javalab.bookshelf.models.Book;
import com.fujitsu.fs.javalab.bookshelf.models.Users;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.*;
import com.fujitsu.fs.javalab.bookshelf.web.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    UsersService usersService;
    @Autowired
    SearchService searchService;
    @Autowired
    BookService bookService;
    @Autowired
    UsersWishService usersWishService;
    @Autowired
    UsersHavingService usersHavingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hiPage(Model model) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model,
                               @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("error", error);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (!name.equals("anonymousUser")) {
            return "redirect:/profile";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Users users = usersService.getUsersByNickname(name);
        model.addAttribute("user", users);
        return "profile";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(ModelMap model,
                               @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("error", error);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (!name.equals("anonymousUser")) {
            return "redirect:/profile";
        } else {
            return "registration";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPost(ModelMap model,
                                   @RequestParam(value = "user", required = false) String username,
                                   @RequestParam(value = "email", required = false) String email,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "surname", required = false) String surname,
                                   @RequestParam(value = "city", required = false) String city,
                                   @RequestParam(value = "password1", required = false) String password1,
                                   @RequestParam(value = "password2", required = false) String password2) {

        if (usersService.ifNicknameExists(username)) {
            return "redirect:/registration?error=loginIsBusy";
        } else {
            if (password1.equals(password2)) {

                password1 = HashUtils.md5Apache(password1);

                usersService.addNewUsers(username, email, name, surname, city, password1, null);
                Set<GrantedAuthority> roles = new HashSet();
                roles.add(new SimpleGrantedAuthority("CLIENT"));
                UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, password1, roles);
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(token);
            }

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String login = auth.getName();
            Users user = usersService.getUsersByNickname(login);
            model.addAttribute("user", user);
            return "profile";
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchPage(Model model) {
        return "search";
    }

    @RequestMapping(value = "/search_results", method = RequestMethod.GET)
    public String getSearchResults(Model model,
                                   @RequestParam(value = "author_name", required = false) String authorName,
                                   @RequestParam(value = "author_surname", required = false) String authorSurname,
                                   @RequestParam(value = "bookname", required = false) String bookname) {
        List<Book> bookList = searchService.getSearchResult(authorName, authorSurname, bookname);
        model.addAttribute("bookList", bookList);
        return "search_results";
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String getBook(Model model,
                          @RequestParam(value = "id", required = false) int id) {
        model.addAttribute("book", bookService.getById(id));
        return "book";
    }

    @RequestMapping(value = "/addwishing", method = RequestMethod.GET)
    public String addWishing(Model model) {
        return "addwishing";
    }

    @RequestMapping(value = "/postwishing", method = RequestMethod.POST)
    public String postWishing(Model model,
                              @RequestParam(value = "author_name", required = false) String authorName,
                              @RequestParam(value = "author_surname", required = false) String authorSurname,
                              @RequestParam(value = "author_middlename", required = false) String authorMiddlename,
                              @RequestParam(value = "bookname", required = false) String bookname) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Users users = usersService.getUsersByNickname(name);
        usersWishService.addWishing(authorName, authorSurname, authorMiddlename, bookname, users);
        return getProfilePage(model);
    }

    @RequestMapping(value = "/addhaving", method = RequestMethod.GET)
    public String addHaving(Model model) {
        return "addhaving";
    }

    @RequestMapping(value = "/posthaving", method = RequestMethod.POST)
    public String postHaving(Model model,
                             @RequestParam(value = "author_name", required = false) String authorName,
                             @RequestParam(value = "author_surname", required = false) String authorSurname,
                             @RequestParam(value = "author_middlename", required = false) String authorMiddlename,
                             @RequestParam(value = "pubhouse", required = false) String pubhouse,
                             @RequestParam(value = "pub_year", required = false) String pubyear,
                             @RequestParam(value = "description", required = false) String description,
                             @RequestParam(value = "bookname", required = false) String bookname) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Users users = usersService.getUsersByNickname(name);
        usersHavingService.addUsersHaving(users, authorName, authorSurname, authorMiddlename, pubhouse, pubyear, description, bookname);
        return getProfilePage(model);
    }
}
