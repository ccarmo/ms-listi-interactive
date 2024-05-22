package com.dev.clibank.app.services.auth;

import com.dev.clibank.app.rest.records.LoginRecord;
import com.dev.clibank.app.rest.records.RegisterUserRecord;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.UserRepository;
import com.dev.clibank.infra.db.mapper.UserMapper;
import com.dev.clibank.infra.db.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public RegisterUserRecord signup(RegisterUserRecord input) {
        RegisterUserRecord inputCrypt = new RegisterUserRecord(input.email(), passwordEncoder.encode(input.password()),input.name());
      userRepository.createUser(inputCrypt);
      return inputCrypt;
    }



    public Optional<UserModel> authenticate(LoginRecord loginRecord) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRecord.email(),loginRecord.password()));
        Optional<User> user = userRepository.getUsername(loginRecord.email());
        UserModel userAuthModel = userMapper.userToUserModel(user.get());
        return Optional.of(userAuthModel);
    }
}
