package com.example.ecommercehiringchallenge.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCategoryRequest {
    @NotBlank
    private String categoryName;
}
