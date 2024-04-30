package com.dev.clibank.app.rest.controller;


import com.dev.clibank.app.rest.records.UserRecord;
import com.dev.clibank.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserRecord> createUser(@RequestParam("name")  String name) {
        UserRecord userDTO = userService.createUser(name);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<UserRecord> getUser(@RequestParam("name") String name) {
        Optional<UserRecord> userDTO = userService.getUserService(name);
        return ResponseEntity.ok(userDTO.get());
    }
}
