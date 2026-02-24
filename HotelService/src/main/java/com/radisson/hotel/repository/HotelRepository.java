package com.radisson.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.radisson.hotel.entites.Hotel;

public interface HotelRepository  extends JpaRepository<Hotel, Long> {

}
