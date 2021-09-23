package com.example.postman.services;

import com.example.postman.dto.CustomerDto;
import com.example.postman.dto.UserDto;
import com.example.postman.entity.Customer;
import com.example.postman.entity.User;
import com.example.postman.repository.CustomerRepository;
import com.example.postman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtoList= new ArrayList<>();
        List<User> user = userRepository.findAll();
        for (User u : user){
            userDtoList.add(new UserDto(u.getId(),
                    u.getUserName(),
                    u.getPassword(),
                    u.isActive(),
                    u.getRoles()));
        }
        return userDtoList;
    }


    @Override
    public UserDto saveUser(UserDto userDto) {
        User entitiy = null;

        if (userDto.getId() != null) {
            entitiy = userRepository.findById(userDto.getId()).get();
        } else {
            entitiy = new User();
        }

        //entitiy.setId(customerDto.getId());
        entitiy.setUserName(userDto.getUserName());
        entitiy.setPassword(passwordEncoder.encode(userDto.getPassword()));
        entitiy.setActive(userDto.getActive());
        entitiy.setRoles(userDto.getRoles());

        entitiy = userRepository.save(entitiy);

        //return only id because of data volume
        return UserDto.builder().
                id(entitiy.getId()).
                userName(entitiy.getUserName()).
                password(entitiy.getPassword()).
                active(entitiy.isActive()).
                roles(entitiy.getRoles()).
                build();
    }
}
