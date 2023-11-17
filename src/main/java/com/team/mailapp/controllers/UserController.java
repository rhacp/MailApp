package com.team.mailapp.controllers;

import com.team.mailapp.models.entities.User;
import com.team.mailapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        log.info(String.valueOf(user.getId()));
        userService.getUserList().remove(user);
        log.info(String.valueOf(userService.getUserList().size()));

        return "redirect:/api/users";
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("userList", userService.getUserList());

        return "admin_page";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable long id, Model model) {
        //search in userList by id
        User user = userService.getUserById(id);
        //model add attribute user found
        model.addAttribute("user", user);

        return "user_page";
    }
}
