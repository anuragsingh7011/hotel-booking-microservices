package com.radisson.hotel.kafka;

import com.radisson.hotel.dto.UserEventDTO;
import com.radisson.hotel.entites.UserEvent;
import com.radisson.hotel.repository.UserEventRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserKafkaConsumer {

    private final UserEventRepository repository;

    @KafkaListener(topics = "user-profile1", groupId = "hotel-group2")
    public void consume(UserEventDTO dto) {

        System.out.println("Message received from Kafka: " + dto);

        UserEvent entity = UserEvent.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNo(dto.getPhoneNo())
                .address(dto.getAddress())
                .build();

        repository.save(entity);

        System.out.println("User event saved in Hotel DB");
    }
}