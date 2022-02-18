package com.example.demo.controller;

import com.example.demo.dto.OrdersCarModelDto;
import com.example.demo.service.impl.OrdersCarServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/orderscarmodel")
public class OrdersCarModelController {
    private final OrdersCarServiceImpl ordersCarService;

    @PostMapping("/saveOrdersCarModel")
    public ResponseEntity<?> saveOrdersCarModel (@Valid @RequestBody OrdersCarModelDto dto) throws Exception{
        ordersCarService.saveOrdersCarModel(dto);
        return ResponseEntity.ok("saved successfully");
    }
}
