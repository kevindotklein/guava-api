package com.guava.api.domain.user.dto;

import com.guava.api.domain.user.UserRole;

import java.time.Instant;
import java.util.UUID;

public record UserResponse(UUID id, String email, String username, UserRole role, Instant createdAt) {
}
