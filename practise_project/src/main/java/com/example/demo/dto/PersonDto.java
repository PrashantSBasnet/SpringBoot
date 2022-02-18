package com.example.demo.dto;

import com.example.demo.entity.Person;
import lombok.Data;

@Data
public class PersonDto {
    private Integer id;
    private String name;
    private String address;

    public PersonDto(Person entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.address = entity.getAddress();
    }




}
