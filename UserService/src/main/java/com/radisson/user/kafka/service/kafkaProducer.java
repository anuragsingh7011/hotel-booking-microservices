package com.radisson.user.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.radisson.user.dto.UserRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, UserRequestDTO> kafkaTemplate;

    public void producerMessage(String topic, UserRequestDTO message) {
        kafkaTemplate.send(topic, message);
    }
    
    public void producerMessage(String topic, int partition, String key, UserRequestDTO message) {
        kafkaTemplate.send(topic, partition, key, message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Sent to partition: " +
                                result.getRecordMetadata().partition());
                    } else {
                        System.out.println("Kafka error: " + ex.getMessage());
                    }
                });
    }
    
    public void producerMessage(String topic, String key, UserRequestDTO message) {

        kafkaTemplate.send(topic, key, message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Sent to partition: " +
                                result.getRecordMetadata().partition());
                    } else {
                        System.out.println("Kafka error: " + ex.getMessage());
                    }
                });
    }
    
}