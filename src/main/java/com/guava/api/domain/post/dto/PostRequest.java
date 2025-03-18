package com.guava.api.domain.post.dto;

import java.time.Instant;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record PostRequest(@NotNull @NotBlank String title, @NotNull @NotBlank String content) {
}
