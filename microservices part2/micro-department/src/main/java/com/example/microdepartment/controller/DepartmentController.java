package com.example.microdepartment.controller;


import com.example.microdepartment.entity.Department;
import com.example.microdepartment.service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger logger = LogManager.getLogger(DepartmentController.class);


    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department){

        logger.info("------->>>> department saved");
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department findDepartment (@PathVariable ("id") Long departmentid){
        //have to add log for zipkin
        logger.info("------->>>> department  found");
        return  departmentService.findDepartmentById(departmentid);
    }

}
