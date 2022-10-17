package com.company.CustomerAPI.repository;
import com.company.CustomerAPI.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByLevel(String level);

    List<Customer> findByAddressState(String state);
}
