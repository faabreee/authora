package com.authora.infrastructure.persistence.jpa.repository;

import com.authora.infrastructure.persistence.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {
}
