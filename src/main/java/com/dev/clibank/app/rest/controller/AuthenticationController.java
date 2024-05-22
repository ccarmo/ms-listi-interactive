package com.dev.clibank.app.rest.controller;


import com.dev.clibank.app.rest.records.LoginRecord;
import com.dev.clibank.app.rest.records.LoginResponseRecord;
import com.dev.clibank.app.rest.records.RegisterUserRecord;
import com.dev.clibank.app.services.auth.AuthenticationService;
import com.dev.clibank.app.services.auth.JwtService;
import com.dev.clibank.infra.db.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<RegisterUserRecord> register(@RequestBody RegisterUserRecord registerUserDto) {
        RegisterUserRecord registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponseRecord> authenticate(@RequestBody LoginRecord loginRecord) {
        Optional<UserModel> user = authenticationService.authenticate(loginRecord);

        String jwtToken = jwtService.generateToken(user.get());

        LoginResponseRecord loginResponseRecord = new LoginResponseRecord(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponseRecord);

    }
}
