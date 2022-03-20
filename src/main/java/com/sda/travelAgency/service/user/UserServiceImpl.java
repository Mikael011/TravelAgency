package com.sda.travelAgency.service.user;

import com.sda.travelAgency.dto.city.CityFullDto;
import com.sda.travelAgency.dto.userDto.UserDto;
import com.sda.travelAgency.dto.userDto.UserLoginDto;
import com.sda.travelAgency.mapper.CityMapper;
import com.sda.travelAgency.mapper.UserMapper;
import com.sda.travelAgency.model.User;
import com.sda.travelAgency.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo repo;

    public UserServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDto login(UserLoginDto loginDto) {
        User user = repo.findByEmail(loginDto.getEmail());
        if (user != null & user.getPassword().equals(loginDto.getPassword())) {
            return UserMapper.userDto(user);
        }
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> returnList = new ArrayList<>();
        repo.findAll().forEach(entity -> {
            returnList.add(UserMapper.userDto(entity));
        });

        return returnList;
    }
}
