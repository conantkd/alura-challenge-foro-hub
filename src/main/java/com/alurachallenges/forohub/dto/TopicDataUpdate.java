package com.alurachallenges.forohub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDataUpdate(
        @NotNull
        Long id,

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje
) {
}
