package com.radisson.user.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	private Long ratingId;
	private Long userId;
	private Long hotelId;
	private Integer rate;
	private String feedback;
}
