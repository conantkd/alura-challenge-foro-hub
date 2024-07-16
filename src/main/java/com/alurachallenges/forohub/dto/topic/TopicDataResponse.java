package com.alurachallenges.forohub.dto.topic;

import com.alurachallenges.forohub.dto.UserData;

public record TopicDataResponse(
        Long id,
        UserData user,
        String curso,
        String titulo,
        String mensaje
) {
}
