package com.example.ecommercehiringchallenge.controller;

import com.example.ecommercehiringchallenge.dto.request.CreateCreditCardRequest;
import com.example.ecommercehiringchallenge.service.Imp.CreditCardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/creditcard")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping("/save")
    public void creditCardSave(@RequestBody CreateCreditCardRequest createCreditCardRequest){
        creditCardService.saveCreditCard(createCreditCardRequest);
    }
}
