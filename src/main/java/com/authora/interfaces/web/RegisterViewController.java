package com.authora.interfaces.web;

import com.authora.application.dto.RegisterUserCommand;
import com.authora.application.port.in.IRegisterUser;
import com.authora.application.port.out.ILoginAfterRegisterPort;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class RegisterViewController {

    private final IRegisterUser registerUser;
    private final ILoginAfterRegisterPort loginAfterRegisterPort;

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public void register(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        if (registerUser.validateExistenceUser(username)) {
            response.sendRedirect("/register?error");
            return;
        }

        RegisterUserCommand registerUserCommand = new RegisterUserCommand(username, password);

        registerUser.registerUser(registerUserCommand);

        loginAfterRegisterPort.login(registerUserCommand, request, response);
    }

}
