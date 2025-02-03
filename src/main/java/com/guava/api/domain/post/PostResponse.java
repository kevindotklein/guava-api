package com.guava.api.domain.post;

import java.time.Instant;
import java.util.UUID;

import com.guava.api.domain.user.UserResponse;

public record PostResponse(UUID id, String title, String content, Integer hearts, Instant createdAt,
        UserResponse user) {
}
