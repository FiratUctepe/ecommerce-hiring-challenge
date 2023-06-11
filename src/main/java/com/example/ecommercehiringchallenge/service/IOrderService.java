package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.dto.request.CreateOrderRequest;
import com.example.ecommercehiringchallenge.dto.response.OrderResponseDto;
import com.example.ecommercehiringchallenge.exception.NotFoundCustomerException;
import com.example.ecommercehiringchallenge.model.Customer;
import com.example.ecommercehiringchallenge.model.Order;
import com.example.ecommercehiringchallenge.model.Product;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface IOrderService {

    public OrderResponseDto createOrder(CreateOrderRequest createOrderRequest) throws MessagingException;
    public List<OrderResponseDto> getAllOrdersOrByCustomerId(Optional<Integer> customerId);
    public OrderResponseDto getOrderById(Integer orderId);
    public void deleteOrder(Integer orderId);
}
