package com.guava.api.domain.post.dto;

import java.time.Instant;
import java.util.UUID;

import com.guava.api.domain.user.dto.UserResponse;

public record PostResponse(UUID id, String title, String content, Integer hearts, Instant createdAt,
        UserResponse user) {
}
