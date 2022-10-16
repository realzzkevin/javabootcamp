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

////
//    private Address address1 = new Address("main", "New York", "NY", "10000");
//    private Customer customer1 = new Customer(5, "John", "Walker", address1, "Gold");
//    private Address address2 = new Address("anywhere", "Night City", "AZ", "34567");
//    private  Customer customer2 = new Customer(6, "Johnny", "Silverhand", address2, "Silver");
//    List<Customer> customerList = new ArrayList<>(Arrays.asList(customer1, customer2));

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomer() {
        return serviceLayer.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createANewCustomer(@RequestBody Customer customer) {
////        Customer newCus = serviceLayer.createNewCustomer(customer);
////        customerList.add(newCus);
////        return newCus;
//        customerList.add(customer);
//        return customer;
        return serviceLayer.createCustomer(customer);
    }

//    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
//        for (Customer temp : customerList) {
//            if (temp.getId() == customer.getId()) {
//                temp.setId(customer.getId());
//                temp.setLastName(customer.getLastName());
//                temp.setFirstName(customer.getFirstName());
//                temp.setAddress(customer.getAddress());
//                temp.setLevel(customer.getLevel());
//                break;
//            }
//        }
        serviceLayer.updateCustomer(customer);
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteACustomerById(@PathVariable int id) {
//        for( int i = 0; i < customerList.size(); i++) {
//            if (customerList.get(i).getId() == id){
//                customerList.remove(i);
//                break;
//            }
//        }
        serviceLayer.deleteCustomerByID(id);

    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> findCustomerById (@PathVariable int id) {
//        for( int i = 0; i < customerList.size(); i++) {
//            if (customerList.get(i).getId() == id){
//                return customerList.get(i);
//            }
//        }
//        return null;
        return serviceLayer.findByID(id);
    }

//    @RequestMapping(value = "/level/{level}",method = RequestMethod.GET)
    @GetMapping(value = "/level/{level}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findCustomerByLevel( @PathVariable String level) {
//       return customerList.stream()
//                .filter(customer -> customer.getLevel().equals(level))
//                .collect(Collectors.toList());
        return serviceLayer.findByLevel(level);
    }

//    @RequestMapping(value = "/state/{state}", method = RequestMethod.GET)
    @GetMapping(value = "/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findCustomerByState(@PathVariable String state) {
//        return customerList.stream()
//                .filter(customer -> customer.getAddress().getState().equals(state))
//                .collect(Collectors.toList());
        return null;
    }

}
