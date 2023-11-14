package com.team.mailapp.services;

import com.team.mailapp.models.dtos.UserDTO;
import com.team.mailapp.models.entities.User;

import java.util.List;

public interface UserService {

    User createUser(UserDTO userDTO);

    List<User> getUserList();

    User getUserById(long id);
}
