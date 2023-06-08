package com.example.ecommercehiringchallenge.dto.util;

import lombok.Getter;

@Getter
public enum ERole {
    ADMIN("ADMIN"),USER("USER");

    private final String value;

    ERole(String value) {
        this.value = value;
    }
}
