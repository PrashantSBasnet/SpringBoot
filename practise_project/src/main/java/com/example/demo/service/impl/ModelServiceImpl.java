package com.example.demo.service.impl;

import com.example.demo.dto.ModelDto;
import com.example.demo.entity.Model;
import com.example.demo.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    @Override
    public ModelDto save(ModelDto dto) {

        Model model;

        if (dto.getId() != null && dto.getId() != 0) {



        } else {
            model = new Model();

            model.setId(dto.getId());
            model.setName(dto.getName());
            model.setModel_year(dto.getModel_year());
        }

        return dto;
    }
}
