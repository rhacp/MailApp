package com.team.mailapp.controllers;

import com.team.mailapp.models.dtos.UserDTO;
import com.team.mailapp.models.entities.Mail;
import com.team.mailapp.models.entities.User;
import com.team.mailapp.services.MailService;
import com.team.mailapp.services.UserDTOService;
import com.team.mailapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api/form")
public class FormController {

    private final MailService mailService;
    private final UserDTOService userDTOService;
    private final UserService userService;

    public FormController(MailService mailService, UserDTOService userDTOService, UserService userService) {
        this.mailService = mailService;
        this.userDTOService = userDTOService;
        this.userService = userService;
    }

    @GetMapping("/show")
    public String showForm(Model model) {
        model.addAttribute("userDTO", userDTOService.createUserDTO());
        log.info("From showForm: Create user");

        return "user_form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute UserDTO userDTO) {
        //check if userDTO is valid
        if (!userDTOService.validateUserDTO(userDTO)) {
            return "error_page";
        }

        User user = userService.createUser(userDTO);
        mailService.sendMail(user.getMail(), prepareMail(user));
        log.info("From submitForm: " + user.getFirstName());

        return "redirect:/api/mainpage";
    }

    private Mail prepareMail(User user) {
        Mail mail = new Mail();
        mail.setSubject("Welcome " + user.getFirstName() + "!");
        mail.setMessage("You can check your account at: http://localhost:8080/api/users/" + user.getId());

        return mail;
    }
}
