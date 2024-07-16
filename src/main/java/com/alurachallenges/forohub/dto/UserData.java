package com.alurachallenges.forohub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserData(
        @NotNull
        Long id,
        @NotBlank
        String username
)
{
}
