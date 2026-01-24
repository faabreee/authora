package com.authora.application.port.out;

import com.authora.application.dto.RegisterUserCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ILoginAfterRegisterPort {
    void login(RegisterUserCommand registerUserCommand, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
