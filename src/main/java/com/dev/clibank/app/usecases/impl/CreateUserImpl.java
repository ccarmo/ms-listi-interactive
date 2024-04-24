package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.rest.dto.UserDTO;
import com.dev.clibank.app.usecases.CreateUser;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.UserRepository;
import com.dev.clibank.infra.db.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CreateUserImpl implements CreateUser {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<UserDTO> createUser(String name) {
        Optional<User> user = userRepository.createUser(name);
        return  Optional.of(userMapper.userToUserDTO(user.get()));
    }
}
