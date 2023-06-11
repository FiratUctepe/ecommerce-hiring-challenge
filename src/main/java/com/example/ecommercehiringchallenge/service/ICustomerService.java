package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.dto.request.CreateCustomerRequest;
import com.example.ecommercehiringchallenge.dto.request.UpdateCustomerRequest;
import com.example.ecommercehiringchallenge.dto.response.CustomerResponseDto;
import com.example.ecommercehiringchallenge.dto.util.ERole;
import com.example.ecommercehiringchallenge.model.Customer;
import com.example.ecommercehiringchallenge.model.Role;
import com.example.ecommercehiringchallenge.model.Token;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;

public interface ICustomerService {

    public CustomerResponseDto getCustomerById(Integer customerId);
    public CustomerResponseDto createCustomer(CreateCustomerRequest createCustomerRequest) throws MessagingException;
    public CustomerResponseDto updateCustomerById(Integer customerId, UpdateCustomerRequest updateCustomerRequest);
    public void deleteCustomerById(Integer customerId);
    public String customerTokenConfirm(String tokenNumber);
}
