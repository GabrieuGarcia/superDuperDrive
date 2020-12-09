package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.model.Login;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public void login(Login loginForm) {
        loginForm.getUsername();
    }
}
