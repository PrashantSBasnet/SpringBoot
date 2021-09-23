package com.example.postman.services;

import com.example.postman.dto.CustomerDto;
import com.example.postman.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<UserDto> findAll();

    public UserDto saveUser(UserDto userDto);
}
