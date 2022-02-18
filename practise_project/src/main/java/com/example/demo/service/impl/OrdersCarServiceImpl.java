package com.example.demo.service.impl;

import com.example.demo.CustomMessageSource;
import com.example.demo.dto.CarsDto;
import com.example.demo.dto.OrdersCarModelDto;
import com.example.demo.entity.Cars;
import com.example.demo.entity.Orders;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CarsRepo;
import com.example.demo.repository.OrdersRepo;
import com.example.demo.service.OrdersCarService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersCarServiceImpl implements OrdersCarService {

    private final OrdersRepo ordersRepo;
    private final CustomMessageSource customMessageSource;
    private final CarsRepo carsRepo;

    @Override
    public void saveOrdersCarModel(OrdersCarModelDto dto) throws NotFoundException {

    }
}
