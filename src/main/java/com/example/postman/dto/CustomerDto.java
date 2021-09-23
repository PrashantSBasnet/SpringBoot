package com.example.postman.dto;

import com.example.postman.entity.Customer;
import lombok.*;
import org.springframework.validation.FieldError;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer id;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "Address cannot be null")
    @NotBlank(message = "Address cannot be empty")
    private String address;


   public CustomerDto(Customer customer)
    {
        this.id= customer.getId();
        this.name = customer.getName();
        this.address=customer.getAddress();
    }
}
