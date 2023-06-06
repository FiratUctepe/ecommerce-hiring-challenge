package com.example.ecommercehiringchallenge.dto.response;

import com.example.ecommercehiringchallenge.dto.util.OrderCustomerDto;
import com.example.ecommercehiringchallenge.model.Order;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderResponseDto {
    private Integer id;
    private List<ProductResponseDto> products;
    private Date createdDate;
    private Double totalAmount;
    private OrderCustomerDto orderCustomerDto;

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.products = order.getProducts().stream()
                .map((product) -> new ProductResponseDto(product))
                .collect(Collectors.toList());
        this.createdDate = order.getCreatedDate();
        this.totalAmount = order.getTotalAmount();
        this.orderCustomerDto = new OrderCustomerDto(order.getCustomer());
        this.createdDate = order.getCreatedDate();
    }
}
