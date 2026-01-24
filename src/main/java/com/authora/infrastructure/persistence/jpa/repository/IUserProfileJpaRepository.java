package com.authora.infrastructure.persistence.jpa.repository;

import com.authora.infrastructure.persistence.jpa.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserProfileJpaRepository extends JpaRepository<UserProfileEntity, Long> {
}
