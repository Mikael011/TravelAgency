package com.sda.travelAgency.service.user;

import com.sda.travelAgency.dto.userDto.UserDto;
import com.sda.travelAgency.dto.userDto.UserLoginDto;
import com.sda.travelAgency.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto login(UserLoginDto loginDto);
    List<UserDto> findAll();
}
