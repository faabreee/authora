package com.authora.application.usecase;

import com.authora.application.port.in.IRegisterUser;
import com.authora.application.port.out.IPersonPersistencePort;
import com.authora.domain.model.Person;
import com.authora.domain.model.User;
import com.authora.application.port.out.IUserPersistencePort;
import com.authora.domain.service.UserDomainService;
import com.authora.application.dto.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCase implements IRegisterUser {
    private final UserDomainService userDomainService;
    private final IUserPersistencePort userPersistencePort;
    private final IPersonPersistencePort personPersistencePort;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void registerUser(RegisterUserCommand registerUserCommand) {
        userDomainService.validateNewUser(registerUserCommand.username().trim());

        Person person = new Person(registerUserCommand);
        person = personPersistencePort.save(person);

        User user = new User(
                registerUserCommand,
                passwordEncoder.encode(registerUserCommand.password().trim()),
                person
        );

        userPersistencePort.save(user);
    }

    public boolean validateExistenceUser(String username) {
        return userDomainService.findByUsername(username.trim()) != null;
    }
}
