package com.example.ecommercehiringchallenge.dto.request;

import com.example.ecommercehiringchallenge.dto.response.ProductResponseDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {

    @NotNull
    @NotEmpty
    private List<Integer> producId;

    @NotNull
    @NotEmpty
    private Integer customerId;

}
