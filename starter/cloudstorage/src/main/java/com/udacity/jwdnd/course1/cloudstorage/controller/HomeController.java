package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

    private final UserService userService;
    private final FileService fileService;

    public HomeController(UserService userService, FileService fileService) {
        this.userService = userService;
        this.fileService = fileService;
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Authentication authentication) {
        Integer filesaved = fileService.saveFile(authentication, file);
        if(filesaved != null) {
            return "result";
        }
        return "result";
    }
}
