package com.authora.infrastructure.persistence.adapter;

import com.authora.application.port.out.IUserProfilePersistencePort;
import com.authora.domain.model.UserProfile;
import com.authora.infrastructure.persistence.jpa.entity.UserProfileEntity;
import com.authora.infrastructure.persistence.jpa.mapper.IUserProfileDboMapper;
import com.authora.infrastructure.persistence.jpa.repository.IUserProfileJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfilePersistencePort implements IUserProfilePersistencePort {
    private final IUserProfileDboMapper userProfileDboMapper;
    private final IUserProfileJpaRepository userProfileJpaRepository;

    @Override
    public UserProfile save(UserProfile userProfile) {
        UserProfileEntity userProfileEntity = userProfileDboMapper.toEntity(userProfile);
        userProfileEntity = userProfileJpaRepository.saveAndFlush(userProfileEntity);

        return userProfileDboMapper.toDomain(userProfileEntity);
    }
}
