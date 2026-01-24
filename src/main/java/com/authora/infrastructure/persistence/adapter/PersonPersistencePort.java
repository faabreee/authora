package com.authora.infrastructure.persistence.adapter;

import com.authora.application.port.out.IPersonPersistencePort;
import com.authora.domain.model.Person;
import com.authora.infrastructure.persistence.jpa.entity.PersonEntity;
import com.authora.infrastructure.persistence.jpa.mapper.IPersonDboMapper;
import com.authora.infrastructure.persistence.jpa.repository.IPersonJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonPersistencePort implements IPersonPersistencePort {
    private final IPersonJpaRepository personJpaRepository;
    private final IPersonDboMapper personDboMapper;

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = personDboMapper.toEntity(person);
        personEntity = personJpaRepository.saveAndFlush(personEntity);
        return personDboMapper.toDomain(personEntity);
    }

}
