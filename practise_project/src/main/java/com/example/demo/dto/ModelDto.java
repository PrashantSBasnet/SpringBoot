package com.example.demo.dto;

import com.example.demo.entity.Model;
import lombok.Data;


import java.util.Date;

@Data
public class ModelDto {

    private Integer id;

    private String name;

    private Date model_year;

    private Integer status;

    public ModelDto (Model entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.model_year=entity.getModel_year();
        this.status=entity.getStatus();
    }

}
