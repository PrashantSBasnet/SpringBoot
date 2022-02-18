package com.example.demo.dto;

import com.example.demo.entity.Cars;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersCarModelDto {

  private Integer orderId;

  private List<CarsDto> carsDto;

  private List<OrdersDto> ordersDto;

  private Integer status;

}
