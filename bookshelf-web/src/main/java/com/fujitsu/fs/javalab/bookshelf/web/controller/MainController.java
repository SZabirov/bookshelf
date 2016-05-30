package com.fujitsu.fs.javalab.bookshelf.web.controller;

import com.fujitsu.fs.javalab.bookshelf.service.UsersServiceImpl;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.UsersService;
import com.fujitsu.fs.javalab.bookshelf.web.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;


@Controller
public class MainController {

    @Autowired
    UsersService usersService;

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
        model.addAttribute("nickname", name);
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
        }
        else {
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

//        model.addAttribute("username", username);
//        model.addAttribute("client", "CLIENT");

        if (usersService.ifNicknameExists(username)) {
            return "redirect:/registration?error=loginIsBusy";
        }
        else {
            if (password1.equals(password2)) {

                password1 = HashUtils.md5Apache(password1);

                usersService.addNewUsers(username, email, name, surname, city, password1, null);
                Set<GrantedAuthority> roles = new HashSet();
                roles.add(new SimpleGrantedAuthority("CLIENT"));
                UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, password1, roles);
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(token);
            }
        }

        return "profile";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchPage(Model model) {
        return "search";
    }
}
