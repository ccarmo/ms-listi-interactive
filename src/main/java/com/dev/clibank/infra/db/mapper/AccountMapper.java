package com.dev.clibank.infra.db.mapper;


import com.dev.clibank.app.rest.records.AccountRecord;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.TypeAccount;
import com.dev.clibank.domain.vo.Email;
import com.dev.clibank.infra.db.model.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AccountMapper {


    @Mapping(source = "accountModel.typeAccount", target = "typeAccount", qualifiedByName = "mapStringToTypeAccount")
    Account accountModelToAccount(AccountModel accountModel);

    AccountRecord accountModelToAccountRecord(AccountModel accountModel);

    AccountRecord accountToAccountRecord(Account account);

    @Mapping(source = "account.typeAccount", target = "typeAccount", qualifiedByName = "mapTypeAccountToString")
    AccountModel accountToAccountModel(Account account);

    @Named("mapStringToTypeAccount")
    default TypeAccount mapStringToTypeAccount(String typeAccount) {
        return TypeAccount.of(typeAccount);
    }

    @Named("mapTypeAccountToString")
    default String mapEmailToString(TypeAccount typeAccount) {
        return typeAccount.toString();
    }
}
