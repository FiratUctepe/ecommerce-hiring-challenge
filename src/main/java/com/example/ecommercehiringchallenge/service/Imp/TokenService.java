package com.example.ecommercehiringchallenge.service.Imp;

import com.example.ecommercehiringchallenge.model.Token;
import com.example.ecommercehiringchallenge.repository.TokenRepository;
import com.example.ecommercehiringchallenge.service.ITokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements ITokenService {
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public void saveToken(Token token){
        tokenRepository.save(token);
    }
}
