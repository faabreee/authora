package com.authora.application.usecase;

import com.authora.application.port.in.RegisterUser;
import com.authora.application.port.out.PersonPersistencePort;
import com.authora.application.port.out.UserProfilePersistencePort;
import com.authora.domain.model.Person;
import com.authora.domain.model.User;
import com.authora.application.port.out.UserPersistencePort;
import com.authora.domain.model.UserProfile;
import com.authora.domain.service.UserDomainService;
import com.authora.application.dto.RegisterUserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCase implements RegisterUser {
    private final UserDomainService userDomainService;
    private final PasswordEncoder passwordEncoder;

    private final UserPersistencePort userPersistencePort;
    private final PersonPersistencePort personPersistencePort;
    private final UserProfilePersistencePort userProfilePersistencePort;

    @Override
    @Transactional
    public void registerUser(RegisterUserCommand registerUserCommand) {
        Person person = new Person(registerUserCommand);
        person = personPersistencePort.save(person);

        User user = new User(registerUserCommand, passwordEncoder.encode(registerUserCommand.password().trim()), person);
        user = userPersistencePort.save(user);

        UserProfile userProfile = new UserProfile(registerUserCommand, user);
        userProfilePersistencePort.save(userProfile);
    }

    @Transactional
    public boolean validateExistenceUser(String username) {
        return userDomainService.findByUsername(username.trim()) != null;
    }
}
