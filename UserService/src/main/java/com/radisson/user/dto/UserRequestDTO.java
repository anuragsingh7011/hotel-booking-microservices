package com.radisson.user.dto;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRequestDTO {
	
	@NotBlank(message = "Name is required")
	@Size(min = 5, max =15 , message="Name must be between 2 and 15 characters")
	private String name;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email formate")
	private String email;
	
	@Digits(integer = 10, fraction = 0 ,message = " Phone Number must be 10 digits")
	private Long phoneNo;
	
	 @NotBlank(message = "Address is required")
	 @Size(max = 255, message = "Address cannot exceed 255 characters")
	private String address;
}
