package com.radisson.user.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radisson.user.dto.UserRequestDTO;
import com.radisson.user.dto.UserResponseDTO;
import com.radisson.user.entities.User;
import com.radisson.user.exception.ResourceNotFoundException;
import com.radisson.user.kafka.service.KafkaProducer;
import com.radisson.user.repository.UserRepository;
import com.radisson.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final KafkaProducer kafkaProducer;
	
	@Override
	public UserResponseDTO createUser(UserRequestDTO requestDTO) {
		User userEntity = userRepository.save(mapToEntity(requestDTO));
		System.out.println("UserService.createOrder()");

		String message = convertObjToJson(requestDTO);

		System.out.println(" JSON message sending to Kafka ::: " + message);
		// send message to kafka
		int partitionCount = 4;

		for (int i = 0; i < 1000; i++) {

		    UserRequestDTO newDto = UserRequestDTO.builder()
		            .name(requestDTO.getName() + i)
		            .email("user" + i + "@gmail.com")
		            .phoneNo(900L + i)
		            .address(requestDTO.getAddress())
		            .build();

		    int partition = i % partitionCount;

		    kafkaProducer.producerMessage("user-profile1",partition,String.valueOf(newDto.getPhoneNo()),newDto);
		}
		System.out.println(" MESSAGE SENT to KAFKA.....");
		
		return mapToDTO(userEntity);
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
	
	public User mapToEntity(UserRequestDTO requestDTO) {
		
		 return User.builder()
	                .name(requestDTO.getName())
	                .email(requestDTO.getEmail())
	                .phoneNo(requestDTO.getPhoneNo())
	                .address(requestDTO.getAddress())
	                .build();
	}
	
	public UserResponseDTO mapToDTO(User user) {

	    if (user == null) {
	        return null;
	    }

	    return UserResponseDTO.builder()
	            .name(user.getName())
	            .email(user.getEmail())
	            .phoneNo(user.getPhoneNo())
	            .address(user.getAddress())
	            .build();
	}
	private String convertObjToJson(UserRequestDTO requestDTO) {
		ObjectMapper mapper = new ObjectMapper();

		String json = null;
		try {
			json = mapper.writeValueAsString(requestDTO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}
	
	

}
