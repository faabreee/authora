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
public class UserProfile {
    private Long id;
    private String uuid;
    private String phone;
    private User user;
    private Integer status;

    public UserProfile(RegisterUserCommand registerUserCommand, User user) {
        this.uuid = UUID.randomUUID().toString();
        this.phone = registerUserCommand.phone().trim();
        this.user = user;
        this.status = EntityStatus.ACTIVE.getValue();
    }
}
