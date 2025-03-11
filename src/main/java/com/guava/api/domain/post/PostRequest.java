package com.guava.api.domain.post;

import java.time.Instant;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record PostRequest(@NotNull @NotBlank String title, @NotNull @NotBlank String content,
                                @NotNull @PositiveOrZero Integer hearts, @NotNull Instant createdAt,
                                @NotNull UUID userId) {
}
