package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute("user") User user) {
        User userFound = userService.getUser(user.getUsername());
        if(userFound!= null) {
            return "home";
        }
        return "login";
    }
}
