package com.example.demo.service;

import com.example.demo.dto.CarsDto;

import java.util.List;
import java.util.Map;

public interface CarsService {

    Map<String,Object> findById(Integer id) throws Exception;

    List<CarsDto> findByStatus (Integer status) throws Exception;

    CarsDto save(CarsDto dto) throws Exception;

    List<CarsDto> findByName (String name) throws Exception;


}
