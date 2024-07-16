package com.alurachallenges.forohub.services;

import com.alurachallenges.forohub.dto.topic.TopicData;
import com.alurachallenges.forohub.infra.exceptions.IntegrityValidation;
import com.alurachallenges.forohub.models.Topic;
import com.alurachallenges.forohub.repositories.TopicRepository;
import com.alurachallenges.forohub.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TopicService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    TopicRepository topicRepository;

    public TopicData publish(
            @RequestBody
            @Valid
            TopicData topicData
            )
    {
        if(!userRepository.findById(topicData.usuario()).isPresent())
        {
            throw new IntegrityValidation("Usuario no encontrado");
        }

        var user = userRepository.findById(topicData.usuario()).get();
        Topic topic;
        topic = new Topic(
                null,
                user,
                topicData.curso(),
                topicData.titulo(),
                topicData.mensaje(),
                topicData.fecha(),
                true
        );

        topicRepository.save(topic);
        return new TopicData(topic);
    }

}
