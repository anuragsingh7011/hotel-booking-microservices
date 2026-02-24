package com.radisson.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radisson.user.dto.UserRequestDTO;
import com.radisson.user.dto.UserResponseDTO;
import com.radisson.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/profile")
	public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO requestDTO){
		UserResponseDTO responseDTO=userService.createUser(requestDTO);
		return new ResponseEntity<UserResponseDTO>(responseDTO, HttpStatus.CREATED);
				
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseDTO> getSingleUser(@PathVariable Long userId){
		UserResponseDTO responseDTO=userService.getUserByID(userId);
		return new ResponseEntity<UserResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
}
