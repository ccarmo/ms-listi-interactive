package com.dev.clibank.infra.db.repository;

import com.dev.clibank.domain.entities.Statement;
import com.dev.clibank.domain.repository.StatementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementRepositoryDb implements StatementRepository {
    @Override
    public void savedStatement(Statement statement) {

    }

    @Override
    public List<Statement> getStatementAccount(String idAccount) {
        return null;
    }
}
