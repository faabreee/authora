package com.authora.application.port.in;

import com.authora.application.dto.RegisterUserCommand;

public interface RegisterUser {
    void registerUser(RegisterUserCommand registerUserCommand) ;
    boolean validateExistenceUser(String username);
}
