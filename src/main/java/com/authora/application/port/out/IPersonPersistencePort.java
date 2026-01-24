package com.authora.application.port.out;

import com.authora.domain.model.Person;

public interface IPersonPersistencePort {
    Person save(Person person);
}
