package com.company.CustomerAPI.controller;

import com.company.CustomerAPI.model.Customer;
import com.company.CustomerAPI.services.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomer() {
        return serviceLayer.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createANewCustomer(@RequestBody Customer customer) {

        return serviceLayer.createCustomer(customer);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {

        serviceLayer.updateCustomer(customer);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteACustomerById(@PathVariable int id) {
        serviceLayer.deleteCustomerByID(id);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> findCustomerById (@PathVariable int id) {
        return serviceLayer.findByID(id);
    }

//    @RequestMapping(value = "/level/{level}",method = RequestMethod.GET)
    @GetMapping(value = "/level/{level}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findCustomerByLevel( @PathVariable String level) {
        return serviceLayer.findByLevel(level);
    }

    @GetMapping(value = "/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findCustomerByState(@PathVariable String state) {
        return serviceLayer.findByState(state);
    }

}
