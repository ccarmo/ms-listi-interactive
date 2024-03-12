package com.dev.clibank.infra.file;

import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserFileRepository implements UserRepository {

    private static final String USER_FILE_NAME = "user.json";
    @Override
    public Optional<User> getUser(String idUser) {
        List<User> userList = FileJsonManager.getFileListJson(USER_FILE_NAME,User.class);
        for (User user : userList) {
            if (user.getId().equals(idUser)) {
                return  Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
