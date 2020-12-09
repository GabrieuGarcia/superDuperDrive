package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Login;
import com.udacity.jwdnd.course1.cloudstorage.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ModelAndView getLoginPage() {
//        ModelAndView modelAndView = new ModelAndView("login");
//        modelAndView.addObject("login", new LoginForm());
//        return modelAndView;
//    }

        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String getLoginPage() {
        return "login";
        }


        @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String sendLoginPage(@ModelAttribute(value="login")Login login, Model model) {
        loginService.login(login);
        return "login";
    }

}
