package com.guava.api.domain.user;

import java.time.Instant;
import java.util.UUID;

public record UserResponse(UUID id, String email, String username, UserRole role, Instant createdAt) {
}
