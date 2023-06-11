package com.example.ecommercehiringchallenge.repository;

import com.example.ecommercehiringchallenge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByUserName(String userName);
}
