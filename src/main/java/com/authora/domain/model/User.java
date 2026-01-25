package com.authora.domain.model;

import com.authora.application.dto.RegisterUserCommand;
import com.authora.domain.valueobject.EntityStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String uuid;
    private String username;
    private String email;
    private String emailVerified;
    private String password;
    private Boolean enabled;
    private Person person;
    private Integer status;

    public User(RegisterUserCommand registerUserCommand, String passwordHash, Person person) {
        this.uuid = UUID.randomUUID().toString();
        this.username = registerUserCommand.username().trim();
        this.email = registerUserCommand.email().trim();
        this.emailVerified = registerUserCommand.emailVerified().trim();
        this.password = passwordHash;
        this.enabled = true;
        this.person = person;
        this.status = EntityStatus.ACTIVE.getValue();
    }
}
