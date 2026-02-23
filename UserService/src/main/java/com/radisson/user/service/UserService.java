package com.radisson.user.service;

import java.util.List;

import com.radisson.user.dto.UserRequestDTO;
import com.radisson.user.dto.UserResponseDTO;

public interface UserService {
	
	UserResponseDTO createUser(UserRequestDTO requestDTO);
	
	UserResponseDTO getUserByID(Long userId);
	
	List<UserResponseDTO> getAllUser();
	
	UserResponseDTO updateUser(Long userId,UserRequestDTO requestDTO);
	

}
