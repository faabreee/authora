package com.authora.infrastructure.repository.jpa;

import com.authora.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJpaRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
