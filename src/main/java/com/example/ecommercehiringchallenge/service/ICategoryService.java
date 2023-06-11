package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.dto.request.CreateCategoryRequest;
import com.example.ecommercehiringchallenge.dto.request.UpdateCategoryRequest;
import com.example.ecommercehiringchallenge.dto.response.CategoryResponseDto;
import java.util.List;

public interface ICategoryService {

    public CategoryResponseDto createCategory(CreateCategoryRequest createCategoryRequest);
    public List<CategoryResponseDto> getAllCategory();
    public CategoryResponseDto getCategoryById(Integer categoryId);
    public CategoryResponseDto updateCategory(Integer categoryId, UpdateCategoryRequest updateCategoryRequest);
    public void deleteCategory(Integer categoryId);

}
