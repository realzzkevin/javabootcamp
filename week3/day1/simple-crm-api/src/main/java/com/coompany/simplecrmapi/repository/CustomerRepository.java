package com.coompany.simplecrmapi.repository;

import com.coompany.simplecrmapi.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public List<Customer> findByCompany(String company);
    public List<Customer> findByLastName(String z);

    public List<Customer> findByCompanyAndLastName(String company, String lastName);
}
