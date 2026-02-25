package com.radisson.hotel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radisson.hotel.entites.UserEvent;
import com.radisson.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelController {

	private final HotelService hotelService;
	
	 @GetMapping("/users")
	    public List<UserEvent> getAllUsers() {
	        return hotelService.getAllUsers();
	    }
}
