package com.example.microdepartment.service;

import com.example.microdepartment.entity.Department;
import com.example.microdepartment.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;


    public Department save(Department department) {
        return departmentRepo.save(department);
    }

    public Department findDepartmentById( Long id){
        return  departmentRepo.findDepartmentById(id);
    }
}
