package com.fujitsu.fs.javalab.bookshelf.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;


@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hiPage(Model model) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("error", error);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if (!name.equals("anonymousUser")) {
            return "redirect:/";
        }
        else {
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
    public String getRegistrationPage(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getSearchPage(Model model) {
        return "search";
    }
}
