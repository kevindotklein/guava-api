package com.guava.api.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    GUEST("GUEST"),
    USER("USER"),
    PREMIUM("PREMIUM"),
    ADMIN("ADMIN");

    private final String name;
}
