package com.sda.travelAgency.mapper;

import com.sda.travelAgency.dto.userDto.UserDto;
import com.sda.travelAgency.model.User;

public class UserMapper {
    public static UserDto userDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
