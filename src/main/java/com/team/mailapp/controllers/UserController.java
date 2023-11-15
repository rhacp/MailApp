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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UserController {

    private final MailService mailService;
    private final UserDTOService userDTOService;
    private final UserService userService;

    public UserController(MailService mailService, UserDTOService userDTOService, UserService userService) {
        this.mailService = mailService;
        this.userDTOService = userDTOService;
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public String getUsers(Model model) {
        model.addAttribute("userList", userService.getUserList());

        return "admin_page";
    }

    @GetMapping("/api/users/{id}")
    public String getUser(@PathVariable long id, Model model) {

        //search in userList by id
        User user = userService.getUserById(id);

        //model add atribute user found
        model.addAttribute("user", user);

        return "user_page";
    }

    @GetMapping("/api/form/show")
    public String showForm(Model model) {
        model.addAttribute("userDTO", userDTOService.createUserDTO());
        log.info("From showForm: Create user");

        return "user_form";
    }

    @PostMapping("/api/form/submit")
    public String submitForm(@ModelAttribute UserDTO userDTO) {
        User user = userService.createUser(userDTO);

        if (user.getFirstName() == null) {
            return "error_page";
        }

        mailService.sendMail(user.getMail(), prepareMail(user));

        log.info("From submitForm: " + user.getFirstName());

        return "redirect:/api/mainpage";
    }

    public Mail prepareMail(User user) {
        Mail mail = new Mail();
        mail.setSubject("Welcome " + user.getFirstName() + "!");
        mail.setMessage("You can check your account at: http://localhost:8080/api/users/" + user.getId());

        return mail;
    }
}
