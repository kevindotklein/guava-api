package com.guava.api.domain.auth.dto;

public record LoginResponse(String token, Long expiresIn) {
}
