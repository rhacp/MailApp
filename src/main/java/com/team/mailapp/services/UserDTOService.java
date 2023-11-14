package com.team.mailapp.services;

import com.team.mailapp.models.dtos.UserDTO;

public interface UserDTOService {

    boolean validateUserDTO(UserDTO userDTO);

    UserDTO createUserDTO();
}
