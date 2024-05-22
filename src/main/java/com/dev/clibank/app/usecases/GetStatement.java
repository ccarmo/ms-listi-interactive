package com.dev.clibank.app.usecases;

import com.dev.clibank.domain.entities.Statement;

import java.util.List;
import org.springframework.stereotype.Service;


public interface GetStatement {

    List<Statement> getStatement(String idAccount);
}
