package com.team.mailapp.services;

import com.team.mailapp.models.dtos.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserDTOServiceImpl implements UserDTOService{

    @Override
    public boolean validateUserDTO(UserDTO userDTO) {
        return !userDTO.getFirstName().isEmpty()
                && !userDTO.getLastName().isEmpty();
    }

    @Override
    public UserDTO createUserDTO() {
        return new UserDTO();
    }
}
