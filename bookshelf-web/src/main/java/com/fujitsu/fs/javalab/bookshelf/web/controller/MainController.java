package com.fujitsu.fs.javalab.bookshelf.web.controller;

import com.fujitsu.fs.javalab.bookshelf.models.*;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.*;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.BookService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.SearchService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.UsersService;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.UsersWishService;
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

    @Autowired
    MessagesService messagesService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hiPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (!name.equals("anonymousUser")) {
            model.addAttribute("login", name);
        }
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
    public String getProfilePage(Model model,
                                 @RequestParam(value = "id", required = false) Integer id) {
        Users user;
        List<UsersHaving> usersHavings;
        List<UsersWish> usersWishes;
        if (id == null) {
            System.out.println("Null id");
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            user = usersService.getUsersByNickname(name);
        }
        else {
            System.out.println("Not null id");
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            if (usersService.getUsersByNickname(name).getId() != id) {
                System.out.println("NOT CURRENT");
                user = usersService.getUserById(id);
                model.addAttribute("notCurrent", "notCurrent");
            }
            else {
                user = usersService.getUsersByNickname(name);
            }
        }
        usersHavings = user.getUsersHavings();
        usersWishes = user.getUsersWishes();
        model.addAttribute("havings", usersHavings);
        model.addAttribute("wishes", usersWishes);
        model.addAttribute("user", user);
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
                                   @RequestParam(value = "phone", required = false) String phone,
                                   @RequestParam(value = "password1", required = false) String password1,
                                   @RequestParam(value = "password2", required = false) String password2) {

        if (usersService.ifNicknameExists(username)) {
            model.addAttribute("error", "Пользователь с таким логином уже существует");
            return "registration";
        }
        if (usersService.ifEmailExists(email)) {
            model.addAttribute("error", "Пользователь с таким email уже существует");
            return "registration";
        }
        if (!UserController.checkWithRegExp(email, "email")) {
            model.addAttribute("error", "Неправильный email: " + email);
            return "registration";
        }
        if (!UserController.checkWithRegExp(username, "login")) {
            model.addAttribute("error", "Login " + username + " is incorrect");
            return "registration";
        }
        if (!UserController.checkWithRegExp(name, "name")) {
            model.addAttribute("error", "Неправильное имя: " + name);
            return "registration";
        }
        if (!UserController.checkWithRegExp(surname, "name")) {
            model.addAttribute("error", "Неправильная фамилия: " + surname);
            return "registration";
        }
        if (!UserController.checkWithRegExp(city, "name")) {
            model.addAttribute("error", "Неправильный город: " + city);
            return "registration";
        }
        if (!UserController.checkWithRegExp(phone, "phone")) {
            model.addAttribute("error", "Неправильный номер " + phone);
            return "registration";
        }
        if (!UserController.checkWithRegExp(password1, "pass")) {
            model.addAttribute("error", "Неправильный формат пароля: " + password1);
            return "registration";
        }
        if (password1.equals(password2)) {
                password1 = HashUtils.md5Apache(password1);

                usersService.addNewUsers(username, email, name, surname, city, phone, password1, null);
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
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        List<Users> users = usersHavingService.getAllUsersForBook(book);
        model.addAttribute("owners", users);
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
        return "redirect:/profile";
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
        return "redirect:/profile";
    }

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String getConnectPage(Model model,
                                 @RequestParam(value = "id") Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Users user1 = usersService.getUsersByNickname(name);
        List<Book> having = usersHavingService.getAllBooksThatUserHas(user1);
        Users user2 = usersService.getUserById(id);
        List<Book> wishing = usersHavingService.getAllBooksThatUserHas(user2);

        model.addAttribute("havingBooks", having);
        model.addAttribute("wishingBooks", wishing);
        model.addAttribute("receiver", user2);
        return "connect";
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String sendOffer(Model model,
                            @RequestParam(value = "id") Integer id,
                            @RequestParam(value = "have") Integer have,
                            @RequestParam(value = "wish") Integer wish) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Users user1 = usersService.getUsersByNickname(name);

        Users user2 = usersService.getUserById(id);

        Book havingBook = bookService.getById(have);
        Book wishBook = bookService.getById(wish);

        messagesService.addNewMessage(user1, user2, havingBook, wishBook);

        model.addAttribute("success", "Ваше предложение успешно отправлено.");
        return "success";
    }

    @RequestMapping(value = "/deleteHaving", method = RequestMethod.POST)
    public String deleteHaving(Model model,
                            @RequestParam(value = "id") Integer id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Users user = usersService.getUsersByNickname(name);

        Book book = bookService.getById(id);

        usersHavingService.deleteUsersHaving(user, book);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/deleteWish", method = RequestMethod.POST)
    public String deleteWish(Model model,
                               @RequestParam(value = "id") Integer id) {

        usersWishService.deleteById(id);

        return "redirect:/profile";
    }


    @RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
    public String deleteMessage(Model model,
                             @RequestParam(value = "id") Integer id) {

        messagesService.deleteById(id);

        return "redirect:/user/requests";
    }

}
