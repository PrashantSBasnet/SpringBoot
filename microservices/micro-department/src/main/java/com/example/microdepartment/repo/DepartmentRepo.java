package com.example.microdepartment.repo;

import com.example.microdepartment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Department findDepartmentById(Long id);
}
