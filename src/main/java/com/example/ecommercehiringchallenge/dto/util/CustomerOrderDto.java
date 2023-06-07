package com.example.ecommercehiringchallenge.dto.util;

import com.example.ecommercehiringchallenge.dto.response.ProductResponseDto;
import com.example.ecommercehiringchallenge.model.Customer;
import com.example.ecommercehiringchallenge.model.Order;
import com.example.ecommercehiringchallenge.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CustomerOrderDto {
    private Integer id;
    private Double totalAmount;
    private List<ProductResponseDto> products;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date createdDate;

    public CustomerOrderDto(Order order) {
        this.id = order.getId();
        this.products = order.getProducts().stream()
                .map((product) -> new ProductResponseDto(product))
                .collect(Collectors.toList());
        this.totalAmount = order.getTotalAmount();
        this.createdDate = order.getCreatedDate();
    }
}
