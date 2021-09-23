package com.example.postman.controller;

import com.example.postman.Exception.BaseController;
import com.example.postman.repository.UserRepository;
import com.example.postman.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.postman.Exception.GlobalApiResponse;
import com.example.postman.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController extends BaseController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserService userService;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/list")
    public ResponseEntity<GlobalApiResponse> showUser(){
        List<UserDto> userDtos= userService.findAll();
        return new ResponseEntity<>(successResponse(customMessageSource.get("crud.get", customMessageSource.get("user")), userDtos), HttpStatus.OK);
    }


    //use global api response
    @PostMapping("/saveUser"
    )
    public UserDto saveUser(@Valid @RequestBody UserDto userDto)
    {
        userDto=userService.saveUser(userDto);
        if (userDto==null){
            throw new NullPointerException();
        }
        return userDto;
    }
}
