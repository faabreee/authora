package com.authora.domain.service;

import com.authora.application.port.out.IUserPersistencePort;
import com.authora.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDomainService {
    private final IUserPersistencePort userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username.trim());
    }

    public boolean validateNewUser(String username) {
        return userRepository.findByUsername(username.trim()) != null;
    }

}
