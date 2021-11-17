package com.example.microusers.controller;

import com.example.microusers.VO.ResponseTemplateVO;
import com.example.microusers.entity.User;
import com.example.microusers.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        logger.info("------->>>> user saved");
        return userService.saveUser(user);
    }

//    @GetMapping("/{id}")
//    public User findUser (@PathVariable ("id") Long userid){
//        return  userService.findUserById(userid);
//    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        logger.info("------->>>> user found");
        return userService.getUserWithDepartment(userId);
    }

}
