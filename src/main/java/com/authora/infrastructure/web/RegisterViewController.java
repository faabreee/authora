package com.authora.infrastructure.web;

import com.authora.application.dto.RegisterUserCommand;
import com.authora.application.port.in.RegisterUser;
import com.authora.infrastructure.security.web.SpringSecurityLoginAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import static com.authora.infrastructure.utils.DateUtils.convertStringToDate;

@Controller
@RequiredArgsConstructor
public class RegisterViewController {
    private final RegisterUser registerUser;
    private final SpringSecurityLoginAdapter springSecurityLoginAdapter;

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public void register(
            @RequestParam Long documentTypeId,
            @RequestParam String documentNumber,
            @RequestParam String firstName,
            @RequestParam String secondName,
            @RequestParam String firstLastName,
            @RequestParam String secondLastName,
            @RequestParam String birthDate,
            @RequestParam Long genderId,
            @RequestParam String phone,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String emailVerified,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        if (registerUser.validateExistenceUser(username)) {
            response.sendRedirect("/register?error");
            return;
        }

        RegisterUserCommand registerUserCommand = new RegisterUserCommand(
                documentTypeId,
                documentNumber,
                firstName,
                secondName,
                firstLastName,
                secondLastName,
                convertStringToDate(birthDate),
                genderId,
                phone,
                username,
                password,
                email,
                emailVerified
        );

        registerUser.registerUser(registerUserCommand);

        springSecurityLoginAdapter.login(registerUserCommand, request, response);
    }

}
