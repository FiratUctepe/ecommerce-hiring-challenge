package com.example.ecommercehiringchallenge.dto.response;

import com.example.ecommercehiringchallenge.model.Product;
import lombok.Data;

@Data

public class ProductResponseDto {
    private String productName;

    private Double price;

    private Integer stock;

    private String description;

    public ProductResponseDto(Product product){
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.description = product.getDescription();
    }
}
