package com.team.mailapp.controllers;

import com.team.mailapp.models.dtos.UserDTO;
import com.team.mailapp.models.entities.User;
import com.team.mailapp.services.UserDTOService;
import com.team.mailapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UserController {

    private final UserDTOService userDTOService;
    private final UserService userService;

    public UserController(UserDTOService userDTOService, UserService userService) {
        this.userDTOService = userDTOService;
        this.userService = userService;
    }

    @GetMapping("/api/form/show")
    public String showForm(Model model) {
        model.addAttribute("userDTO", userDTOService.createUserDTO());
        log.info("From showForm: Create user");

        return "user_form";
    }

    @PostMapping("/api/form/submit")
    public String submitForm(@ModelAttribute UserDTO userDTO) {
        //add validator service
        User user = userService.createUser(userDTO);

        log.info("From submitForm: " + user.getFirstName());

        return "redirect:/api/mainpage";
    }
}
