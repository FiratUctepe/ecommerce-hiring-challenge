package com.example.ecommercehiringchallenge.dto.util;

import com.example.ecommercehiringchallenge.dto.response.OrderResponseDto;
import com.example.ecommercehiringchallenge.model.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderCustomerDto {

    private Integer id;

    private String userName;

    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date createdDate;

    public OrderCustomerDto(Customer customer){
        this.id = customer.getId();
        this.userName = customer.getUserName();
        this.password = customer.getPassword();
        this.firstName= customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.age = customer.getAge();
        this.createdDate = customer.getCreatedDate();
    }

}
