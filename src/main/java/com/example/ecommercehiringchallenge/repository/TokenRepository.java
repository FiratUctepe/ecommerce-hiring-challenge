package com.example.ecommercehiringchallenge.repository;

import com.example.ecommercehiringchallenge.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Integer> {

    //Token sınıfının
    Optional<Token> findByTokenCode(String tokenCode);
}
