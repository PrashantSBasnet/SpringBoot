package com.example.microusers.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_info")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String address;
    private Long departmentid;

}
