package com.example.postman.services;

import com.example.postman.dto.CustomerDto;
import com.example.postman.entity.Customer;
import com.example.postman.repository.CustomerRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> findAll() {
        List<CustomerDto> customerDtoList = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        for (Customer c : customers) {
            customerDtoList.add(new CustomerDto(c.getId()
                    , c.getName(), c.getAddress()));
        }
        return customerDtoList;
    }


    @Override
    public void deleteCustomerbyId(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer entitiy = null;

        if (customerDto.getId() != null) {
            entitiy = customerRepository.findById(customerDto.getId()).get();
        } else {
            entitiy = new Customer();
        }

        //entitiy.setId(customerDto.getId());
        entitiy.setName(customerDto.getName());
        entitiy.setAddress(customerDto.getAddress());

        entitiy = customerRepository.save(entitiy);


        //return only id because of data volume
        return CustomerDto.builder().
                id(entitiy.getId()).
                name(entitiy.getName()).
                address(entitiy.getAddress()).
                build();
    }

    @Override
    public List<CustomerDto> searchCustomer(String keyword) {
        String searchword = "%" + keyword + "%";
        List<Customer> customerSearch = customerRepository.searchCustomer(searchword);

        return customerSearch.stream().map(c ->
                CustomerDto.builder().
                        id(c.getId()).
                        name(c.getName()).
                        address(c.getAddress())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getCustomerById(Integer id) {
       List<Customer> customerById = customerRepository.getCustomerById(id);

       return customerById.stream().map(c->
               CustomerDto.builder().
                       id(c.getId()).
                       name(c.getName()).
                       address(c.getAddress()).
                       build()).collect(Collectors.toList());
    }

}
