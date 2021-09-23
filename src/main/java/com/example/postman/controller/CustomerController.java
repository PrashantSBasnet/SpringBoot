package com.example.postman.controller;

import com.example.postman.Exception.BaseController;
import com.example.postman.Exception.GlobalApiResponse;
import com.example.postman.dto.CustomerDto;
import com.example.postman.entity.Customer;
import com.example.postman.repository.CustomerRepository;
import com.example.postman.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController extends BaseController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public ResponseEntity<GlobalApiResponse> showCustomers(){
        List<CustomerDto> customerDtos= customerService.findAll();
        return new ResponseEntity<>(successResponse(customMessageSource.get("crud.get", customMessageSource.get("customer")), customerDtos), HttpStatus.OK);
    }


    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") Integer id) {
        customerService.deleteCustomerbyId(id);
        return "customer";
    }


    //use global api response
    @PostMapping("/saveCustomer")
    public CustomerDto saveCustomer(@Valid @RequestBody CustomerDto customerDto)
    {
        customerDto=customerService.saveCustomer(customerDto);
        if (customerDto==null){
           throw new NullPointerException();
        }
        return customerDto;
    }




    @PutMapping("/updateCustomer")
    public ResponseEntity<GlobalApiResponse> updateCustomer(@Valid @RequestBody CustomerDto customerDto)
    {
        if( customerDto.getId()!=null) {
            customerDto = customerService.updateCustomer(customerDto);
        }
        if (customerDto==null){
            throw new NullPointerException();
        }
        return new ResponseEntity<>(successResponse(customMessageSource.get("crud.update", customMessageSource.get("customer")), customerDto), HttpStatus.OK);
    }



    @GetMapping("/")
    public String openCustomer() {
        return "customer";
    }


    @GetMapping("/search")
    public ResponseEntity<GlobalApiResponse> searchCustomer(@RequestParam("name")String name) throws Exception {


        try{
            List<CustomerDto> customerDtoList=customerService.searchCustomer(name);
            return new ResponseEntity<>(successResponse(customMessageSource.get("crud.get", customMessageSource.get("customer")), customerDtoList), HttpStatus.OK);

        }
        catch(Exception e){
            return new ResponseEntity<>(errorResponse("failed", e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/find-by-id")
    public ResponseEntity<GlobalApiResponse> findbyId(@RequestParam(value = "id") Integer id) throws Exception {

        try {
            CustomerDto customerDtoList = customerService.getCustomerById(id);
            return new ResponseEntity<>(successResponse(customMessageSource.get("crud.get", customMessageSource.get("customer")), customerDtoList), HttpStatus.OK);

        } catch (Exception e) {
            e.getMessage();
            return new ResponseEntity<>(errorResponse("failed", e.getMessage()), HttpStatus.NOT_FOUND);
        }

    }

}
