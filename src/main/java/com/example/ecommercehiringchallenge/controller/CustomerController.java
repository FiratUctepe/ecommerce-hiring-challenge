package com.example.ecommercehiringchallenge.controller;

import com.example.ecommercehiringchallenge.dto.request.CreateCustomerRequest;
import com.example.ecommercehiringchallenge.dto.request.UpdateCustomerRequest;
import com.example.ecommercehiringchallenge.dto.response.CustomerResponseDto;
import com.example.ecommercehiringchallenge.repository.CustomerRepository;
import com.example.ecommercehiringchallenge.service.Imp.CustomerService;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/customer")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Integer customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> customerTokenConfirm(@RequestParam String token){
        return ResponseEntity.ok(customerService.customerTokenConfirm(token));
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) throws MessagingException {
        return new ResponseEntity<>(customerService.createCustomer(createCustomerRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> updateCustomerById(@PathVariable Integer customerId,
                                                                  @RequestParam UpdateCustomerRequest updateCustomerRequest){

        return ResponseEntity.ok(customerService.updateCustomerById(customerId,updateCustomerRequest));

    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomerById(@PathVariable Integer customerId){
        customerService.deleteCustomerById(customerId);
    }
}
