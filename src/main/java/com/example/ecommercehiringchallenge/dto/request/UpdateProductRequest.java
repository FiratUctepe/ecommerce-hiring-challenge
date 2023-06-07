package com.example.ecommercehiringchallenge.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateProductRequest {

    @NotBlank
    private String productName;

    @Min(value = 1)
    @NotNull
    private Double price;

    @Min(value = 0)
    @NotNull
    private Integer stock;

    private String description;
}
