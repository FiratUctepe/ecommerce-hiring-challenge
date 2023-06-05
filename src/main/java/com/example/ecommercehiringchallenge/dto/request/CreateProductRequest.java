package com.example.ecommercehiringchallenge.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductRequest {

    @NotBlank(message = "Ürün ismi boş veya tanımsız olamaz")
    private String productName;

    @Min(value = 1)
    @NotBlank
    private Double price;

    @Min(value = 0)
    @NotBlank
    private Integer stock;

    private String description;

    @NotBlank(message = "Kategori boş veya tanımsız olamaz")
    private String categoryName;
}
