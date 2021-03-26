package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public String upload(@RequestParam("file") MultipartFile file) {
        Integer filesaved = fileService.saveFile(file);
        if(filesaved != null) {
            return "result";
        }
        return "result";
    }

//    private User getPrincipal() {
//        User user = null;
//        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
//            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        }
//        return user;
//    }

}
