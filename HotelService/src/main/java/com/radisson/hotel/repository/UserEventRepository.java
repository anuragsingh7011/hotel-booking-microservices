package com.radisson.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radisson.hotel.entites.UserEvent;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
}