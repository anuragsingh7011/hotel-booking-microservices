package com.radisson.hotel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEventDTO {

    private String name;
    private String email;
    private Long phoneNo;
    private String address;
}