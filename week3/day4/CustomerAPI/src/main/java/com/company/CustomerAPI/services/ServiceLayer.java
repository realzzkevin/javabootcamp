package com.company.CustomerAPI.services;

import com.company.CustomerAPI.model.Address;
import com.company.CustomerAPI.model.Customer;
//import com.company.CustomerAPI.repository.AddressRepository;
import com.company.CustomerAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer {
    private CustomerRepository repo;

    @Autowired
    public ServiceLayer(CustomerRepository repo) {
        this.repo = repo;
    }
    
    public List<Customer> findAll() {
        return repo.findAll();
    }

    public Customer createCustomer(Customer customer) {

        return repo.save(customer);
    }

    public void updateCustomer(Customer customer) {
        repo.save(customer);
    }

    public void deleteCustomerByID(int id) {
        repo.deleteById(id);
    }

    public Optional<Customer>  findByID(int id) {
        Optional<Customer> customer = repo.findById(id);
        if (customer.isPresent()) return customer;
        return null;
    }

    public List<Customer> findByLevel(String level) {

        return repo.findByLevel(level);
    }

    public List<Customer> findByState(String state) {
        return repo.findByAddressState(state);
    }

}
