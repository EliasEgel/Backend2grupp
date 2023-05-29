package com.example.demo.Repositories;

import com.example.demo.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.name = ?1")
    Optional<Customer> findCustomerByName(String name);
}
