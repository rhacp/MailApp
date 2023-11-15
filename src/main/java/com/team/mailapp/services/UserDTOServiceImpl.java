package com.team.mailapp.services;

import com.team.mailapp.models.ValidDomain;
import com.team.mailapp.models.dtos.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserDTOServiceImpl implements UserDTOService {

    @Override
    public boolean validateUserDTO(UserDTO userDTO) {
        //Check mail
        if (!userDTO.getMail().contains("@")) return false;
        String[] mailArray = userDTO.getMail().split("@");
        if (mailArray[0].length() < 3) return false;
        if (!mailArray[1].equals(ValidDomain.YAHOO.getValue()) || !mailArray[1].equals(ValidDomain.GMAIL.getValue())) return false;

        //Check first and last name
        if (userDTO.getFirstName().equals(null) || userDTO.getLastName().equals(null)) return false;
        if (userDTO.getFirstName().length() < 3 || userDTO.getLastName().length() < 3) return false;

        return true;
    }

    @Override
    public UserDTO createUserDTO() {
        return new UserDTO();
    }
}
