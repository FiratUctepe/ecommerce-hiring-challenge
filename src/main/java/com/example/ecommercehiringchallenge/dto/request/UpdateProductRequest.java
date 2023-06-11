package com.example.ecommercehiringchallenge.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
