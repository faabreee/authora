package com.authora.infrastructure.persistence.jpa.mapper;

import com.authora.domain.model.Person;
import com.authora.infrastructure.persistence.jpa.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IPersonDboMapper {
    Person toDomain(PersonEntity personEntity);
    PersonEntity toEntity(Person person);
}
