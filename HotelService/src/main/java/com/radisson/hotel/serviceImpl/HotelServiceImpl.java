package com.radisson.hotel.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radisson.hotel.entites.UserEvent;
import com.radisson.hotel.repository.UserEventRepository;
import com.radisson.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

	private final UserEventRepository repository;
	
	@Override
	public List<UserEvent> getAllUsers() {
		 return repository.findAll();
	}

}
