package com.sda.travelAgency.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserLoginDto {
    private String email;
    private String password;
}
