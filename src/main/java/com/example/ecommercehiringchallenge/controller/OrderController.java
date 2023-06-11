package com.example.ecommercehiringchallenge.controller;

import com.example.ecommercehiringchallenge.dto.request.CreateOrderRequest;
import com.example.ecommercehiringchallenge.dto.response.OrderResponseDto;
import com.example.ecommercehiringchallenge.service.Imp.CreditCardService;
import com.example.ecommercehiringchallenge.service.Imp.OrderService;

import javax.mail.MessagingException;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/order")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;
    private final CreditCardService creditCardService;

    public OrderController(OrderService orderService,
                           CreditCardService creditCardService) {
        this.orderService = orderService;
        this.creditCardService = creditCardService;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAllOrdersOrByCustomerId(@RequestParam Optional<Integer> customerId){
        return ResponseEntity.ok(orderService.getAllOrdersOrByCustomerId(customerId));
    }

    @GetMapping("/{orderId}")
    ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Integer orderId){
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody @Valid CreateOrderRequest createOrderRequest) throws MessagingException {

        return new ResponseEntity<>(orderService.createOrder(createOrderRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
    }

}
