package com.coompany.simplecrmapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity//Customer go into database
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//
@Table(name = "customer")//give the entity a different name than Customer
public class Customer {
    @Id //primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//java going to generates this value
    private Integer id;
    @Column(name = "fist_name")//use to change name
    private String firstName;
    @Column(name = "last_name")//use to change name
    private String lastName;
    private String company;
    private String phone;

    //TODO: have a set of notes
    @OneToMany(mappedBy = "customerId", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Note> notes;

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(company, customer.company) && Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, company, phone);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
