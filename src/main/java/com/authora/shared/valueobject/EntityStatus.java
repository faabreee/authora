package com.authora.shared.valueobject;

import lombok.Getter;

@Getter
public enum EntityStatus {
    ACTIVE(1),
    INACTIVE(0);

    private final Integer value;

    EntityStatus(Integer value) { this.value = value; }
}
