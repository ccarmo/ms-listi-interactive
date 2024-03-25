package com.dev.clibank.infra.file;

import com.dev.clibank.domain.entities.Statement;
import com.dev.clibank.domain.repository.StatementRepository;

import java.util.List;

public class StatementFileRepository implements StatementRepository {
    private static final String STATEMENT_FILE_NAME = "statement.json";

    @Override
    public void savedStatement(Statement statement) {
        FileJsonManager.updatedFileJson(STATEMENT_FILE_NAME,statement, Statement.class);

    }

    public List<Statement> getStatementAccount(String idAccount) {
        return FileJsonManager.getFileListJson(STATEMENT_FILE_NAME, Statement.class);
    }
}
