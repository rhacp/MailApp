package com.team.mailapp.models.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String mail;
    private LocalDateTime createdAt;
}
