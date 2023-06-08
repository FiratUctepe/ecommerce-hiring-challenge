package com.example.ecommercehiringchallenge.dto.response;

import com.example.ecommercehiringchallenge.dto.util.CustomerOrderDto;
import com.example.ecommercehiringchallenge.model.Customer;
import com.example.ecommercehiringchallenge.model.Order;
import com.example.ecommercehiringchallenge.model.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class CustomerResponseDto {
    private Integer id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private List<CustomerOrderDto> orders;

    private Set<Role> roles;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date createdDate;

    public CustomerResponseDto(Customer customer){
        this.id = customer.getId();
        this.userName = customer.getUserName();
        this.password = customer.getPassword();
        this.firstName= customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.age = customer.getAge();
        this.roles=customer.getRoles();
        this.createdDate = customer.getCreatedDate();
        this.orders = customer.getOrders().stream()
                              .map((order) -> new CustomerOrderDto(order))
                              .collect(Collectors.toList());
    }
}
