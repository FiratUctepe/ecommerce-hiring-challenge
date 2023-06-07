package com.example.ecommercehiringchallenge.controller;

import com.example.ecommercehiringchallenge.dto.request.CreateOrderRequest;
import com.example.ecommercehiringchallenge.dto.response.OrderResponseDto;
import com.example.ecommercehiringchallenge.model.Order;
import com.example.ecommercehiringchallenge.repository.OrderRepository;
import com.example.ecommercehiringchallenge.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/order")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
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
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody @Valid CreateOrderRequest createOrderRequest){

        return ResponseEntity.ok(orderService.createOrder(createOrderRequest));
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
    }

}
