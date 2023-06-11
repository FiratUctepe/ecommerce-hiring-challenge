package com.example.ecommercehiringchallenge.service.Imp;

import com.example.ecommercehiringchallenge.dto.request.CreateCreditCardRequest;
import com.example.ecommercehiringchallenge.model.CreditCard;
import com.example.ecommercehiringchallenge.repository.CreditCardRepository;
import com.example.ecommercehiringchallenge.service.ICreditCardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditCardService implements ICreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Transactional
    public void saveCreditCard(CreateCreditCardRequest createCreditCardRequest){
        CreditCard creditCard = CreditCard.builder().cardName(createCreditCardRequest.getCardName())
                .cardNumber(createCreditCardRequest.getCardNumber())
                .cardExpiredDate(createCreditCardRequest.getCardExpiredDate())
                .cvvNumber(createCreditCardRequest.getCvvNumber())
                .build();

        creditCardRepository.save(creditCard);
    }
}
