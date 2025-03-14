package com.guava.api.domain.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record PostUpdate(@NotNull @NotBlank String title, @NotNull @NotBlank String content,
                         @NotNull @PositiveOrZero Integer hearts) {
}
