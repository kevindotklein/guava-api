package com.guava.api.domain.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.Instant;
import java.util.UUID;

public record PostUpdate(@NotNull @NotBlank String title, @NotNull @NotBlank String content,
                         @NotNull @PositiveOrZero Integer hearts) {
}
