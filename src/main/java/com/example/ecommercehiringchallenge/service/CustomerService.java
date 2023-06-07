package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.dto.request.CreateCustomerRequest;
import com.example.ecommercehiringchallenge.dto.request.UpdateCustomerRequest;
import com.example.ecommercehiringchallenge.dto.response.CustomerResponseDto;
import com.example.ecommercehiringchallenge.exception.NotFoundCustomerException;
import com.example.ecommercehiringchallenge.model.Customer;
import com.example.ecommercehiringchallenge.model.Order;
import com.example.ecommercehiringchallenge.repository.CustomerRepository;
import com.example.ecommercehiringchallenge.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CustomerService(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }
    private Customer findCustomerById(Integer customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundCustomerException("Bu id ile bir müşteri bulunamadı : " + customerId));
    }


    public CustomerResponseDto getCustomerById(Integer customerId) {
        return new CustomerResponseDto(findCustomerById(customerId));
    }

    public CustomerResponseDto createCustomer(CreateCustomerRequest createCustomerRequest){
        Customer customer = new Customer();

        customer.setUserName(createCustomerRequest.getUserName());
        customer.setPassword(createCustomerRequest.getPassword());
        customer.setFirstName(createCustomerRequest.getFirstName());
        customer.setLastName(createCustomerRequest.getLastName());
        customer.setAge(createCustomerRequest.getAge());
        customer.setEmail(createCustomerRequest.getEmail());
        customer.setCreatedDate(Calendar.getInstance().getTime());

        customer.setOrders(new ArrayList<>());

        customerRepository.save(customer);

        return new CustomerResponseDto(customer);

    }


    public CustomerResponseDto updateCustomerById(Integer customerId,UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = findCustomerById(customerId);

        customer.setUserName(updateCustomerRequest.getUserName());
        customer.setPassword(updateCustomerRequest.getPassword());
        customer.setFirstName(updateCustomerRequest.getFirstName());
        customer.setLastName(updateCustomerRequest.getLastName());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setAge(updateCustomerRequest.getAge());

        customerRepository.save(customer);
        return new CustomerResponseDto(customer);
    }

    public void deleteCustomerById(Integer customerId) {
        customerRepository.delete(findCustomerById(customerId));
    }
}
