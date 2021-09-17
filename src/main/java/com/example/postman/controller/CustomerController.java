package com.example.postman.controller;

import com.example.postman.dto.CustomerDto;
import com.example.postman.entity.Customer;
import com.example.postman.repository.CustomerRepository;
import com.example.postman.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RestController
@RequestMapping("/customer")@Controller
@Validated
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public List showCustomers(){
      List<CustomerDto> customerDtoList= customerService.findAll();
      return customerDtoList;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") Integer id){

        customerService.deleteCustomerbyId(id);

        return "customer";
    }

    @RequestMapping("" +
            ".save")
    public String saveCustomer(@RequestBody CustomerDto customerDto, RedirectAttributes redirectAttributes)
    {
        String message="";

        customerDto=customerService.saveCustomer(customerDto);

        if (customerDto==null){
            message="Customer cannot be saved";
        }
        else {
            message="Customer saved successfully";
        }
        redirectAttributes.addFlashAttribute("message", message);
        System.out.println("Saved ");
        return "customer";
    }



    @GetMapping("/")
    public String openCustomer(){
        return "customer";
    }


    @GetMapping("/search")
    public List<CustomerDto> searchCustomer(@RequestParam("name")String name){
            List<CustomerDto> customerDtoList=customerService.searchCustomer(name);
        return customerDtoList;
    }

    @GetMapping("/findbyId")
    public List<CustomerDto> findbyId(@RequestParam(value = "id") Integer id){
            List<CustomerDto> customerDtoList  = customerService.getCustomerById(id);
            return customerDtoList;
    }

}
