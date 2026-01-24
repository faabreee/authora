package com.authora.infrastructure.persistence.jpa.mapper;

import com.authora.domain.model.User;
import com.authora.infrastructure.persistence.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserDboMapper {
    User toDomain(UserEntity userEntity);
    UserEntity toEntity(User user);
}
