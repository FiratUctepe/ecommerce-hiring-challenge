package com.example.ecommercehiringchallenge.dto.request;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private Integer age;
}
