package com.company.CustomerAPI.controller;

import com.company.CustomerAPI.model.Address;
import com.company.CustomerAPI.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();
    private Customer customer1;
    private Customer customer2;
    private Address address1;
    private Address address2;
    @Before
    public void setUp() throws Exception {
        address1 = new Address("main", "New York", "NY", "10000");
        customer1 = new Customer(5, "John", "Walker", address1, "Gold");

        address2 = new Address("anywhere", "Night City", "AZ", "34567");
        customer2 = new Customer(6, "Johnny", "Silverhand", address2, "Silver");
    }

    @Test
    public void shouldCreateNewCustomer() throws Exception {
        String input = mapper.writeValueAsString(customer1);

        mockMvc.perform(
                post("/customer")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(input));

    }

    @Test
    public void shouldReturnCustomerById() throws Exception {
        String input = mapper.writeValueAsString(customer1);

        mockMvc.perform(
                get("/customer/5")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(input));
    }

}