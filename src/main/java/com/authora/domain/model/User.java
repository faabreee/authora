package com.authora.domain.model;

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
    private Integer status;

    public User(String username, String password) {
        this.uuid = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.status = EntityStatus.ACTIVE.getValue();
    }
}
