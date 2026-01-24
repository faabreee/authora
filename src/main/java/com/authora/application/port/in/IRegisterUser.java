package com.authora.application.port.in;

import com.authora.application.dto.RegisterUserCommand;

public interface IRegisterUser {
    void registerUser(RegisterUserCommand registerUserCommand) ;
    boolean validateExistenceUser(String username);
}
