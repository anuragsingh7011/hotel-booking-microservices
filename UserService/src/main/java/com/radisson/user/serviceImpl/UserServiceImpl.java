package com.radisson.user.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.radisson.user.dto.UserRequestDTO;
import com.radisson.user.dto.UserResponseDTO;
import com.radisson.user.exception.ResourceNotFoundException;
import com.radisson.user.repository.UserRepository;
import com.radisson.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Override
	public UserResponseDTO createUser(UserRequestDTO requestDTO) {
		
		return null;
	}

	@Override
	public UserResponseDTO getUserByID(Long userId) {
		userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+userId));
		return null;
	}

	@Override
	public List<UserResponseDTO> getAllUser() {
		
		return null;
	}

	@Override
	public UserResponseDTO updateUser(Long userId, UserRequestDTO requestDTO) {
	
		return null;
	}

}
