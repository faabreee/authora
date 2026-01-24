package com.authora.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Gender {
    private Long id;
    private String uuid;
    private String description;
    private Integer status;

    public Gender(Long id) { this.id = id; }
}
