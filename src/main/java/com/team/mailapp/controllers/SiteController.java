package com.team.mailapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.mailapp.models.dtos.UserDTO;
import com.team.mailapp.models.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// This is a normal Controller, not a REST Controller
@Slf4j
@Controller
public class SiteController {

    @GetMapping("/api/mainpage")
    public String showMainPage() {
        return "main_page";
    }
}
