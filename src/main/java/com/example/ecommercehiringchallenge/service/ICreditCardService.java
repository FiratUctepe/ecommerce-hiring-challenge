package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.dto.request.CreateCreditCardRequest;

public interface ICreditCardService{

    public void saveCreditCard(CreateCreditCardRequest createCreditCardRequest);
}
