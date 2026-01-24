package com.authora.infrastructure.persistence.jpa.mapper;

import com.authora.domain.model.UserProfile;
import com.authora.infrastructure.persistence.jpa.entity.UserProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserProfileDboMapper {
    UserProfile toDomain(UserProfileEntity userProfileEntity);
    UserProfileEntity toEntity(UserProfile userProfile);
}
