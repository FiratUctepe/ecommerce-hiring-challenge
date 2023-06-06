package com.example.ecommercehiringchallenge.dto.util;

import com.example.ecommercehiringchallenge.dto.response.OrderResponseDto;
import com.example.ecommercehiringchallenge.model.Customer;
import lombok.Data;

import java.util.List;

@Data
public class OrderCustomerDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

    public OrderCustomerDto(Customer customer){
        this.id = customer.getId();
        this.firstName= customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.age = customer.getAge();
    }

}
