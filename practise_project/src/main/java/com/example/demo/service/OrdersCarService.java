package com.example.demo.service;

import com.example.demo.dto.OrdersCarModelDto;
import com.example.demo.exception.NotFoundException;

public interface OrdersCarService {

    void saveOrdersCarModel(OrdersCarModelDto dto) throws NotFoundException;
}
