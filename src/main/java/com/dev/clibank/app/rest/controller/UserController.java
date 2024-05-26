package com.dev.clibank.app.rest.controller;


import com.dev.clibank.app.rest.records.UserAuthRecord;
import com.dev.clibank.app.rest.records.UserRecord;
import com.dev.clibank.app.services.UserService;
import com.dev.clibank.infra.db.mapper.UserMapper;
import com.dev.clibank.infra.db.model.UserModel;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/me")
    @Operation(summary = "This method is used to get the client.")
    public ResponseEntity<Object> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAuthRecord userAuthRecord = userMapper.userModelToUserAuth((UserModel) authentication.getPrincipal());
        return ResponseEntity.ok(userAuthRecord);
    }


}
