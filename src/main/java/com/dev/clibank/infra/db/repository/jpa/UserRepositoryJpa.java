package com.dev.clibank.infra.db.repository.jpa;

import com.dev.clibank.domain.entities.User;
import com.dev.clibank.infra.db.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserModel, String> {
    Optional<UserModel> findByName(String name);

}
