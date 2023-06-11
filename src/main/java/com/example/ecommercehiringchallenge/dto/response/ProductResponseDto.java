package com.example.ecommercehiringchallenge.dto.response;

import com.example.ecommercehiringchallenge.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ProductResponseDto {

    private Integer id;
    private String productName;
    private Double price;
    private Integer stock;
    private String description;
    private String categoryName;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date createdDate;

    public ProductResponseDto(Product product){
        this.id = product.getId();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.description = product.getDescription();
        this.categoryName = product.getCategory().getCategoryName();
        this.createdDate = product.getCreatedDate();
    }
}
