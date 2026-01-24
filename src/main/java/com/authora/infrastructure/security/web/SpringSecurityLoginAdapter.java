package com.authora.infrastructure.security.web;

import com.authora.application.dto.RegisterUserCommand;
import com.authora.application.port.out.ILoginAfterRegisterPort;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SpringSecurityLoginAdapter implements ILoginAfterRegisterPort {

    private final AuthenticationManager authenticationManager;

    @Override
    public void login(RegisterUserCommand registerUserCommand, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Authentication authenticated = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerUserCommand.username().trim(),
                        registerUserCommand.password().trim()
                ));

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authenticated);
        SecurityContextHolder.setContext(context);

        new HttpSessionSecurityContextRepository()
                .saveContext(context, request, response);

        new SavedRequestAwareAuthenticationSuccessHandler()
                .onAuthenticationSuccess(request, response, authenticated);
    }
}
