package com.authora.infrastructure.persistence.adapter;

import com.authora.application.port.out.IUserPersistencePort;
import com.authora.domain.model.User;
import com.authora.infrastructure.persistence.jpa.entity.UserEntity;
import com.authora.infrastructure.persistence.jpa.mapper.IUserDboMapper;
import com.authora.infrastructure.persistence.jpa.repository.IUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistencePort implements IUserPersistencePort {
    private final IUserDboMapper userDboMapper;
    private final IUserJpaRepository userJpaRepository;

    @Override
    public User findByUsername(String username) {
        UserEntity userEntity = userJpaRepository.findByUsername(username);
        return userDboMapper.toDomain(userEntity);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userDboMapper.toEntity(user);
        userEntity = userJpaRepository.saveAndFlush(userEntity);

        return userDboMapper.toDomain(userEntity);
    }

}
