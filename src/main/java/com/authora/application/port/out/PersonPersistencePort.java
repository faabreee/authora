package com.authora.application.port.out;

import com.authora.domain.model.Person;

public interface PersonPersistencePort {
    Person save(Person person);
}
