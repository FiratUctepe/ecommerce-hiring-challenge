package com.example.ecommercehiringchallenge.controller;

import com.example.ecommercehiringchallenge.dto.request.CreateCustomerRequest;
import com.example.ecommercehiringchallenge.dto.request.UpdateCustomerRequest;
import com.example.ecommercehiringchallenge.dto.response.CustomerResponseDto;
import com.example.ecommercehiringchallenge.model.Token;
import com.example.ecommercehiringchallenge.service.CustomerService;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api/customer")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

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


    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) throws MessagingException {
        return new ResponseEntity<>(customerService.createCustomer(createCustomerRequest), HttpStatus.CREATED);
    }

//    @PostMapping("/singin")
//    public ResponseEntity<CustomerResponseDto> singInCustomer(@RequestBody String userName,@RequestParam)


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
