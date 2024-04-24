package com.dev.clibank.infra.db.repository.jpa;

import com.dev.clibank.infra.db.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserModel, String> {
}
