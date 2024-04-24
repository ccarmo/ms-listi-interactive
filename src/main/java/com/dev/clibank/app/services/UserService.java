package com.dev.clibank.app.services;

import com.dev.clibank.app.rest.dto.UserDTO;
import com.dev.clibank.app.usecases.CreateUser;
import com.dev.clibank.app.usecases.GetUser;
import com.dev.clibank.app.usecases.impl.CreateUserImpl;
import com.dev.clibank.app.usecases.impl.GetUserImpl;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private GetUserImpl getUserService;


    @Autowired
    private CreateUserImpl createUserService;

    public Optional<UserDTO> getUserService(String idUser) {
        try {
            return getUserService.getUser(idUser);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public UserDTO createUser(String name) {
        Optional<UserDTO> userDTO = createUserService.createUser(name);
        return userDTO.get();
    }
}
