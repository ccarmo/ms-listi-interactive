package com.dev.clibank.infra.db.repository.jpa;

import com.dev.clibank.infra.db.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepositoryJpa extends JpaRepository<TransactionModel, String> {
    List<TransactionModel> findAllByAccountNumber(String accountNumber);

}
