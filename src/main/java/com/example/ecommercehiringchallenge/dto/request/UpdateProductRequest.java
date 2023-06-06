package com.example.ecommercehiringchallenge.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateProductRequest {

    @NotBlank(message = "Ürün ismi boş veya tanımsız olamaz")
    private String productName;

    @Min(value = 1,message = "Ürün fiyatı 1 liranın altında olamaz")
    @NotNull(message = "Ürün fiyatı boş olamaz")
    private Double price;

    @Min(value = 0,message = "Ürün stoğu 0'ın altında olamaz")
    @NotNull(message = "Ürün stoğu boş olamaz")
    private Integer stock;

    private String description;
}
