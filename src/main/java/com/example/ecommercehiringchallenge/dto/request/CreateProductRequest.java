package com.example.ecommercehiringchallenge.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProductRequest {

    @NotBlank(message = "Ürün ismi boş veya tanımsız olamaz")
    private String productName;

    @Min(value = 1,message = "Ürün fiyatı 1 liranın altında olamaz")
    @NotNull(message = "Ürün fiyatı boş olamaz")
    private Double price;

    @Min(value = 0,message = "Ürün stoğu 0'ın altında olamaz")
    @NotNull(message = "Ürün stoğu boş olamaz")
    private Integer stock;

    private String description;

    @NotBlank(message = "Kategori boş veya tanımsız olamaz")
    private String categoryName;
}
