package com.fujitsu.fs.javalab.bookshelf.web.controller;

import com.fujitsu.fs.javalab.bookshelf.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by aygulmardanova on 01.06.16.
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public @ResponseBody
    String returnIfLoginExists(ModelMap model, @RequestParam(value = "nickname") String nickname) {
        Boolean flag = clientService.ifNicknameExists(nickname);
        if (flag) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public @ResponseBody String returnIfEmailExists(ModelMap model, @RequestParam(value = "email") String email) {
        Boolean flag = clientService.ifEmailExists(email);
        if (flag) {
            return "true";
        }
        return "false";
    }

}
