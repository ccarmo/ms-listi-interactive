package com.dev.clibank.infra.db.repository;

import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.UserRepository;
import com.dev.clibank.domain.vo.Email;
import com.dev.clibank.infra.db.mapper.UserMapper;
import com.dev.clibank.infra.db.model.UserModel;
import com.dev.clibank.infra.db.repository.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryDb implements UserRepository {

    @Autowired
    UserRepositoryJpa userRepositoryJpa;

    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<User> getUser(String name) {
        Optional<UserModel> userModelOptional = userRepositoryJpa.findByName(name);
        User user = userMapper.userModelToUser(userModelOptional.get());
        return Optional.of(user);
    }

    @Override
    public Optional<User> createUser(String name) {
        Email email = new Email("teste@teste.com");
        User user = new User(name, email);
        UserModel userModel = userMapper.userToUserModel(user);
        userRepositoryJpa.save(userModel);
        return Optional.of(user);
    }
}
