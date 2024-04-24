package com.dev.clibank.infra.db.mapper;

import com.dev.clibank.app.rest.dto.UserDTO;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.domain.vo.Email;
import com.dev.clibank.infra.db.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "userModel.name", target = "name" )
    @Mapping(source = "userModel.email", target = "email", qualifiedByName = "mapStringToEmail")
    User userModelToUser(UserModel userModel);

    @Mapping(source = "userModel.name", target = "name" )
    @Mapping(source = "userModel.email", target = "email")
    UserDTO userModelToUserDTO(UserModel userModel);

    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.idUser", target = "id")
    @Mapping(source = "user.email", target = "email", qualifiedByName = "mapEmailToString")
    UserModel userToUserModel(User user);

    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.email", target = "email", qualifiedByName = "mapEmailToString")
    UserDTO userToUserDTO(User user);


    @Named("mapStringToEmail")
    default Email mapStringToEmail(String email) {
        return new Email(email);
    }

    @Named("mapEmailToString")
    default String mapEmailToString(Email email) {
        return email.getEmail();
    }

}