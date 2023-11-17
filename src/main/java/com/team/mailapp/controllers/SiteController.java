package com.team.mailapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// This is a normal Controller, not a REST Controller
@Controller
public class SiteController {

    @GetMapping("/api/mainpage")
    public String showMainPage() {
        return "main_page";
    }
}
