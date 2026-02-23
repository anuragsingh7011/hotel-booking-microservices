package com.radisson.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDTO {
private String name;
	
	private String email;
	
	private Long phoneNo;
	
	private String address;
}
