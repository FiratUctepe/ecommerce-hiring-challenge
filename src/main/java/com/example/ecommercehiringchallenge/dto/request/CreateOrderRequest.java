package com.example.ecommercehiringchallenge.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {

    @NotNull
    @NotEmpty
    private List<Integer> productIds;

    @NotNull
    private Integer customerId;

}
