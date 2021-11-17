package com.example.microdepartment.controller;


import com.example.microdepartment.entity.Department;
import com.example.microdepartment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department findDepartment (@PathVariable ("id") Long departmentid){
        return  departmentService.findDepartmentById(departmentid);
    }

}
