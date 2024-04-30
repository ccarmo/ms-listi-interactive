package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.rest.records.UserRecord;
import com.dev.clibank.app.usecases.GetUser;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.UserRepository;
import com.dev.clibank.exceptions.UserNotFoundException;
import com.dev.clibank.infra.db.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserImpl implements GetUser {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<UserRecord> getUser(String idUser) {
        Optional<User> user = userRepository.getUser(idUser);
        UserRecord userRecord = userMapper.userToUserDTO(user.get());
        if(user.isEmpty()) {
            throw new UserNotFoundException("User not found for number: " + idUser);
        } else {
            return Optional.of(userRecord);
        }
    }
}
