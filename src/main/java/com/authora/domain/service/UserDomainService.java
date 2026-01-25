package com.authora.domain.service;

import com.authora.application.port.out.UserPersistencePort;
import com.authora.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDomainService {
    private final UserPersistencePort userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username.trim());
    }

}
