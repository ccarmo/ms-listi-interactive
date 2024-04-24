package com.dev.clibank.app.usecases;

import com.dev.clibank.app.rest.dto.UserDTO;
import com.dev.clibank.domain.entities.User;

import java.util.Optional;
import org.springframework.stereotype.Service;


public interface GetUser {

    Optional<UserDTO> getUser(String idUser);
}
