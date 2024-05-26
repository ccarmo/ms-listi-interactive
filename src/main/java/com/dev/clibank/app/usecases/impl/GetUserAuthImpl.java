package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.rest.records.UserAuthRecord;
import com.dev.clibank.app.usecases.GetUserAuth;
import com.dev.clibank.infra.db.mapper.UserMapper;
import com.dev.clibank.infra.db.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserAuthImpl implements GetUserAuth {

    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<UserAuthRecord> getUserAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAuthRecord userAuthRecord = userMapper.userModelToUserAuth((UserModel) authentication.getPrincipal());
        return Optional.of(userAuthRecord);
    }
}
