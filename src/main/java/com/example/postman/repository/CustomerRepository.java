package com.example.postman.repository;

import com.example.postman.dto.CustomerDto;
import com.example.postman.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer_table c where c.name like ?1", nativeQuery = true)
    List <Customer> searchCustomer(String keyword);

    @Query(value = "select * from customer_table c where c.id =?1", nativeQuery = true)
    List <Customer> getCustomerById (Integer id);

}
