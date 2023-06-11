package com.example.ecommercehiringchallenge.dto.request;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateCreditCardRequest {

    private String cardName;

    @NotBlank
    private String cardNumber;

    @NotBlank
    private String cardExpiredDate;

    @NotNull
    private Integer cvvNumber;
}
