package com.guava.api.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Resource {
    USER("User"),
    POST("Post");

    private final String name;
}
