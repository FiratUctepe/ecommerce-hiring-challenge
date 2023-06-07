package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.dto.request.CreateOrderRequest;
import com.example.ecommercehiringchallenge.dto.response.OrderResponseDto;
import com.example.ecommercehiringchallenge.exception.NotFoundCustomerException;
import com.example.ecommercehiringchallenge.exception.NotFoundOrderException;
import com.example.ecommercehiringchallenge.exception.NotFoundProductException;
import com.example.ecommercehiringchallenge.model.Customer;
import com.example.ecommercehiringchallenge.model.Order;
import com.example.ecommercehiringchallenge.model.Product;
import com.example.ecommercehiringchallenge.repository.CustomerRepository;
import com.example.ecommercehiringchallenge.repository.OrderRepository;
import com.example.ecommercehiringchallenge.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    private Order findOrderById(Integer orderId){
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundOrderException("Bu id ile bir sipariş bulunamamıştır : " + orderId));
    }

    public OrderResponseDto createOrder(CreateOrderRequest createOrderRequest){
        Order order = new Order();

        List<Product> products = productRepository.findAllById(createOrderRequest.getProductIds());
        Customer customer = customerRepository.findById(createOrderRequest.getCustomerId())
                                        .orElseThrow(() -> new NotFoundCustomerException("Bu id ile bir müşteri bulunamadı : " + createOrderRequest.getCustomerId()));

        Double totalAmount = products.stream().mapToDouble(Product::getPrice)
                                                .reduce(0,(a,b) -> a+b);

        order.setProducts(products);
        order.setCustomer(customer);
        order.setCreatedDate(Calendar.getInstance().getTime());
        order.setTotalAmount(totalAmount);

        orderRepository.save(order);

        return new OrderResponseDto(order);
    }

    public List<OrderResponseDto> getAllOrdersOrByCustomerId(Optional<Integer> customerId) {
        if(customerId.isPresent())
            return customerRepository.findById(customerId.get()).get().getOrders()
                    .stream()
                    .map((order) -> new OrderResponseDto(order))
                    .collect(Collectors.toList());

        return orderRepository.findAll().stream()
                .map((order) -> new OrderResponseDto(order))
                .collect(Collectors.toList());
    }

    public OrderResponseDto getOrderById(Integer orderId) {
        return new OrderResponseDto(findOrderById(orderId));
    }

    public void deleteOrder(Integer orderId){
        orderRepository.delete(findOrderById(orderId));
    }
}
