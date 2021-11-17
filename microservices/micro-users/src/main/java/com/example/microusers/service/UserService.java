package com.example.microusers.service;

import com.example.microusers.VO.Department;
import com.example.microusers.VO.ResponseTemplateVO;
import com.example.microusers.entity.User;
import com.example.microusers.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public RestTemplate restTemplate;

    public User saveUser(User user){
        return userRepo.save(user);
    }


    public User findUserById(Long id) {
        return userRepo.findByUserId(id);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userid) {
        ResponseTemplateVO vo = new ResponseTemplateVO();

        //getting user from user microservice
        User user = userRepo.findByUserId(userid);

        //getting department from department microservice
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"  + user.getDepartmentid(),Department.class);

        vo.setUser(user);
        vo.setDepartment(department);


        return vo;

    }
}
