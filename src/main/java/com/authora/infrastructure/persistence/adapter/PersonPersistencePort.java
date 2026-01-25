package com.authora.infrastructure.persistence.adapter;

import com.authora.domain.model.Person;
import com.authora.infrastructure.persistence.jpa.entity.PersonEntity;
import com.authora.infrastructure.persistence.jpa.mapper.PersonDboMapper;
import com.authora.infrastructure.persistence.jpa.repository.PersonJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonPersistencePort implements com.authora.application.port.out.PersonPersistencePort {
    private final PersonJpaRepository personJpaRepository;
    private final PersonDboMapper personDboMapper;

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = personDboMapper.toEntity(person);
        personEntity = personJpaRepository.saveAndFlush(personEntity);
        return personDboMapper.toDomain(personEntity);
    }

}
