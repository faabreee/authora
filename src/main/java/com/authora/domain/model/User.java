package com.authora.domain.model;

import com.authora.application.dto.RegisterUserCommand;
import com.authora.shared.valueobject.EntityStatus;
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
        this.password = passwordHash;
        this.person = person;
        this.status = EntityStatus.ACTIVE.getValue();
    }
}
