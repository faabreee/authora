package com.authora.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {
    private Long id;
    private String uuid;
    private String phone;
    private User user;
    private Integer status;
}
