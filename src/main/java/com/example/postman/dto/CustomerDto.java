package com.example.postman.dto;

import com.example.postman.entity.Customer;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer id;
    private String name;
    private String address;


   public CustomerDto(Customer customer)
    {
        this.id= customer.getId();
        this.name = customer.getName();
        this.address=customer.getAddress();
    }
}
