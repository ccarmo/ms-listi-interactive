package com.dev.clibank.infra.db.mapper;

import com.dev.clibank.app.rest.dto.AccountDTO;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.infra.db.model.AccountModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {


    Account accountModelToAccount(AccountModel accountModel);

    AccountDTO accountModelToAccountDTO(AccountModel accountModel);

    AccountModel accountToAccountModel(Account account);
}
