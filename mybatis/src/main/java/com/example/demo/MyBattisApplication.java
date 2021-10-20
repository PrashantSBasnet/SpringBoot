package com.example.demo;

import com.example.demo.models.Customers;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Customers.class)
@MapperScan("com.example.demo")
@SpringBootApplication
public class MyBattisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBattisApplication.class, args);
    }

}
