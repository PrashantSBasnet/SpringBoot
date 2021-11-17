package com.example.microusers.controller;

import com.example.microusers.VO.ResponseTemplateVO;
import com.example.microusers.entity.User;
import com.example.microusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

//    @GetMapping("/{id}")
//    public User findUser (@PathVariable ("id") Long userid){
//        return  userService.findUserById(userid);
//    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        return userService.getUserWithDepartment(userId);
    }

}
