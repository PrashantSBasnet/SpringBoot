package com.example.postman.services;

import com.example.postman.dto.CustomerDto;
import com.example.postman.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<CustomerDto> findAll();

    void deleteCustomerbyId(Integer id);

    public CustomerDto saveCustomer(CustomerDto customerDto);

    List<CustomerDto> searchCustomer(String keyword);

    List<CustomerDto> getCustomerById (Integer id);
}
