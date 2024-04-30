package com.dev.clibank.infra.db.mapper;


import com.dev.clibank.app.rest.records.AccountRecord;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.infra.db.model.AccountModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {


    Account accountModelToAccount(AccountModel accountModel);

    AccountRecord accountModelToAccountRecord(AccountModel accountModel);

    AccountRecord accountToAccountRecord(Account account);

    AccountModel accountToAccountModel(Account account);
}
