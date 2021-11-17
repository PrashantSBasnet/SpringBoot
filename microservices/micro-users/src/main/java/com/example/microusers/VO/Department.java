package com.example.microusers.VO;




//creating a POJO class

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long id;
    private String departmentname;
    private String departmentcode;
}
