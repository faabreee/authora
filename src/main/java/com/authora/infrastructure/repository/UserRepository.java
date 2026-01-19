package com.authora.infrastructure.repository;

import com.authora.application.repository.IUserRepository;
import com.authora.infrastructure.entity.UserEntity;
import com.authora.infrastructure.repository.jpa.IUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepository implements IUserRepository {

    private final IUserJpaRepository userJpaRepository;

    @Override
    public UserEntity findByUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userJpaRepository.saveAndFlush(userEntity);
    }

}
