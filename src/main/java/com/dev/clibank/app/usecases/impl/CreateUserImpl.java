package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.rest.records.RegisterUserRecord;
import com.dev.clibank.app.rest.records.UserRecord;
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
    public Optional<UserRecord> createUser(RegisterUserRecord user) {
        Optional<User> userCreated = userRepository.createUser(user);
        return  Optional.of(userMapper.userToUserDTO(userCreated.get()));
    }
}
