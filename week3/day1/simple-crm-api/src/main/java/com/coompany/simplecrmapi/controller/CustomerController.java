package com.coompany.simplecrmapi.controller;

import com.coompany.simplecrmapi.dto.Customer;
import com.coompany.simplecrmapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/customer")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(value = "/customer/company/{company}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getCustomerByCompany(@PathVariable String company) {
        return customerRepository.findByCompany(company);
    }

    @PostMapping(value = "/customer")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Customer createNewCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}
