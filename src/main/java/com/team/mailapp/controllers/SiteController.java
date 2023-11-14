package com.team.mailapp.controllers;

import com.team.mailapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// This is a normal Controller, not a REST Controller
@Slf4j
@Controller
public class SiteController {

//    private final UserService userService;
//
//    public SiteController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/api/mainpage")
    public String showMainPage() {
        return "main_page";
    }
}
