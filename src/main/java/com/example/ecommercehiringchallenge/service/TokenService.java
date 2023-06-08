package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.model.Token;
import com.example.ecommercehiringchallenge.repository.TokenRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public void saveToken(Token token){
        tokenRepository.save(token);
    }
}
