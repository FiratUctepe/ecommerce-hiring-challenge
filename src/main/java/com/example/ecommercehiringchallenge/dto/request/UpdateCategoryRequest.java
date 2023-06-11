package com.example.ecommercehiringchallenge.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCategoryRequest {

    @NotBlank
    private String categoryName;
}
