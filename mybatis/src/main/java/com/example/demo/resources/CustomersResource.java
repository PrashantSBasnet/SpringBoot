package com.example.demo.resources;


import com.example.demo.mapper.CustomersMapper;
import com.example.demo.models.Customers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/controller")
public class CustomersResource {


    public CustomersMapper customersMapper;
    public CustomersResource (CustomersMapper customersMapper){
        this.customersMapper=customersMapper;
    }
    @GetMapping("/all")
    public List<Customers> getAll()
    {
        return customersMapper.getAll();
    }
    @GetMapping("/update")
    public List<Customers> update(){
        Customers customers = new Customers();

        customers.setId(122);
        customers.setName("New name3");
        customers.setAddress("New Address3");

        customersMapper.insert(customers);

        return customersMapper.getAll();

    }
}
