package com.dev.clibank.infra.db.repository.jpa;

import com.dev.clibank.infra.db.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositoryJpa extends JpaRepository<AccountModel, String> {
}
