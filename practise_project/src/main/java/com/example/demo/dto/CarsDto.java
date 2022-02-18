package com.example.demo.dto;

import com.example.demo.entity.Cars;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarsDto {

    private Integer id;

    private String name;


    private Integer modelId;
    private String modelName;


    private Integer personId;

    public CarsDto(Cars entity) {
        this.setId(entity.getId());
        this.setName(entity.getName());
        this.setModelId(entity.getModel().getId());
        this.setModelName(entity.getModel().getName());


        this.setPersonId(entity.getPerson().getId());
    }

    public List<CarsDto> toDto(List<Cars> entityList) {
        List<CarsDto> dtoList = new ArrayList<>();
        for (Cars cars : entityList) {
            dtoList.add(new CarsDto(cars));
        }
        return dtoList;
    }

}
