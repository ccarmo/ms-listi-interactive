package com.dev.clibank.app.rest.controller;


import com.dev.clibank.app.rest.dto.UserDTO;
import com.dev.clibank.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestParam("name")  String name) {
        UserDTO userDTO = userService.createUser(name);
        return ResponseEntity.ok(userDTO);
    }
}
