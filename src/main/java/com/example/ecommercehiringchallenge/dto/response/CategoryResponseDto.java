package com.example.ecommercehiringchallenge.dto.response;

import com.example.ecommercehiringchallenge.dto.util.CategoryProductDto;

import com.example.ecommercehiringchallenge.model.Category;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CategoryResponseDto {

    private Integer id;

    private String categoryName;

    private List<CategoryProductDto> products;

    public CategoryResponseDto(Category category){
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
        this.products = category.getProducts().stream()
                .map((product)-> new CategoryProductDto(product))
                .collect(Collectors.toList());
    }
}
