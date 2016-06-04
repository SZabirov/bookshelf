package com.fujitsu.fs.javalab.bookshelf.web.controller;

import com.fujitsu.fs.javalab.bookshelf.models.Client;
import com.fujitsu.fs.javalab.bookshelf.service.interfaces.ClientService;
import com.fujitsu.fs.javalab.bookshelf.web.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aygulmardanova on 01.06.16.
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;


    public static final Pattern login_p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{3,20}$");
    public static final Pattern pass_p = Pattern.compile("^[a-zA-Z0-9]{5,20}$");
    public static final Pattern email_p = Pattern.compile("^([a-z0-9_\\.-])+@[a-z0-9-]+\\.([a-z]{2,4}\\.)?[a-z]{2,4}$");
    public static final Pattern phone_p = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    public static final Pattern name_p = Pattern.compile("^[A-Za-zА-яа-я- ]*$");

    public static boolean checkWithRegExp(String check, String type) {
        Matcher m;
        if (check == null || "".equals(check)) {
            return true;
        }
        switch (type) {
            case "login":
                m = login_p.matcher(check);
                break;
            case "pass":
                m = pass_p.matcher(check);
                break;
            case "email":
                m = email_p.matcher(check);
                break;
            case "phone":
                m = phone_p.matcher(check);
                break;
            case "name":
                m = name_p.matcher(check);
                break;
            default:
                return false;
        }
        return m.matches();
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String getSettingsPage(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Client client = clientService.getClientByNickname(name);
        model.addAttribute("client", client);
        return "settings";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public String settingsPostMethod(ModelMap model,
                                     @RequestParam("id") int id,
                                     @RequestParam(value = "client", required = false) String login,
                                     @RequestParam(value = "email", required = false) String email,
                                     @RequestParam(value = "city", required = false) String city,
                                     @RequestParam(value = "phone", required = false) String phone,
                                     @RequestParam(value = "old_password", required = false) String old_password,
                                     @RequestParam(value = "password1", required = false) String password1,
                                     @RequestParam(value = "password1", required = false) String password2
    ) {
        Client client = clientService.getClientById(id);
        if (clientService.ifNicknameExists(login)) {
            model.addAttribute("error", "Пользователь с таким логином уже существует");
            model.addAttribute("client", client);
            return "settings";
        }
        if (clientService.ifEmailExists(email)) {
            model.addAttribute("error", "Пользователь с таким email уже существует");
            model.addAttribute("client", client);
            return "settings";
        }
        if (!checkWithRegExp(login, "login")) {
            model.addAttribute("error", "Login " + login + " is incorrect");
            model.addAttribute("client", client);
            return "settings";
        }
        if (!checkWithRegExp(email, "email")) {
            model.addAttribute("error", "Неправильный email: " + email);
            model.addAttribute("client", client);
            return "settings";
        }
        if (!checkWithRegExp(city, "name")) {
            model.addAttribute("error", "Неправильный город: " + city);
            model.addAttribute("client", client);
            return "settings";
        }
        if (!checkWithRegExp(phone, "phone")) {
            model.addAttribute("error", "Неправильный номер " + phone);
            model.addAttribute("client", client);
            return "settings";
        }
        if (password1 != null && !"".equals(password1)) {
            if (old_password == null || "".equals(old_password)) {
                model.addAttribute("error", "Введите старый пароль");
                model.addAttribute("client", client);
                return "settings";
            } else if (password2 == null || "".equals(password2)) {
                model.addAttribute("error", "Повторите новый пароль");
                model.addAttribute("client", client);
                return "settings";
            } else if (!clientService.ifCorrectClient(id, HashUtils.md5Apache(old_password))) {
                model.addAttribute("error", "Введен неправильный пароль");
                model.addAttribute("client", client);
                return "settings";
            } else if (!password1.equals(password2)) {
                model.addAttribute("error", "Пароль повторен неправильно");
                model.addAttribute("client", client);
                return "settings";
            } else if (!checkWithRegExp(password1, "pass")) {
                model.addAttribute("error", "Incorrect password format: " + password1);
                model.addAttribute("client", client);
                return "settings";
            } else {
                password1 = HashUtils.md5Apache(password1);
            }
        }
        clientService.updateClient(id, login, email, null, null, city, phone, password1, null);
        System.out.println("client updated");
        model.addAttribute("client", clientService.getClientById(id));
        return "redirect:/profile";
    }

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public String getRequestsPage(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Client client = clientService.getClientByNickname(name);
        System.out.println("Got message for " + name + ": " + client.getMessage());
        System.out.println("Sent message for " + name + ": " + client.getSentMessage());
        model.addAttribute("client", client);
        return "requests";
    }

}
