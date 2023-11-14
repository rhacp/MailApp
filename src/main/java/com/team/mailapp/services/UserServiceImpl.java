package com.team.mailapp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.mailapp.models.dtos.UserDTO;
import com.team.mailapp.models.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private final ObjectMapper objectMapper;
    private List<User> userList = new ArrayList<>(List.of(
            new User(1, "Laur", "Iulian", "mail@gmail.com", LocalDateTime.now()),
            new User(2, "Eric", "Cartman", "ericisevil@gmail.com", LocalDateTime.now())
    ));

    public UserServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public User getUserById(long id) {
        boolean idIsValid = false;
        int validIndex = 0;
        for (int index = 0; index < userList.size(); index++) {
            if (userList.get(index).getId() == id) {
                idIsValid = true;
                validIndex = index;
                break;
            }
        }

        if (idIsValid) {
            return userList.get(validIndex);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = objectMapper.convertValue(userDTO, User.class);
        assignId(user);
        user.setCreatedAt(LocalDateTime.now());
        userList.add(user);

        return user;
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }

    private void assignId(User user) {
        if (userList.isEmpty()) {
            user.setId(1L);
        } else {
            long maxId = 0;
            for (User element : userList) {
                if (element.getId() > maxId) {
                    maxId = element.getId();
                }
            }

            user.setId(maxId + 1L);
        }
    }
}
