package com.radisson.user.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void producerMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
        System.out.println("Message sent to topic: " + topic);
    }
}