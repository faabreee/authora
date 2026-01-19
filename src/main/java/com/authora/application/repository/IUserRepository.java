package com.authora.application.repository;

import com.authora.infrastructure.entity.UserEntity;

public interface IUserRepository {
    UserEntity findByUsername(String username);
    UserEntity save(UserEntity userEntity);
}
