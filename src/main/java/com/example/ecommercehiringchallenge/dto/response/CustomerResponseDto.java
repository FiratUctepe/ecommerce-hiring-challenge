package com.example.ecommercehiringchallenge.dto.response;

import com.example.ecommercehiringchallenge.dto.util.CustomerOrderDto;
import com.example.ecommercehiringchallenge.model.Customer;
import com.example.ecommercehiringchallenge.model.Order;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CustomerResponseDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private List<CustomerOrderDto> orders;

    public CustomerResponseDto(Customer customer){
        this.id = customer.getId();
        this.firstName= customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.age = customer.getAge();
        this.orders = customer.getOrders().stream()
                              .map((order) -> new CustomerOrderDto(order))
                              .collect(Collectors.toList());
    }
}
