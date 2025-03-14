package com.guava.api.common.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final Object query;
    private final Resource resource;

    public ResourceNotFoundException(Object query, Resource resource) {
        super();
        this.query = query;
        this.resource = resource;
    }
}
