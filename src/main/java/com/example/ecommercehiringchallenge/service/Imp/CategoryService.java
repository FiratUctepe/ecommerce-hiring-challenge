package com.example.ecommercehiringchallenge.service.Imp;

import com.example.ecommercehiringchallenge.dto.request.CreateCategoryRequest;
import com.example.ecommercehiringchallenge.dto.request.UpdateCategoryRequest;
import com.example.ecommercehiringchallenge.dto.response.CategoryResponseDto;
import com.example.ecommercehiringchallenge.exception.NotFoundCategoryException;
import com.example.ecommercehiringchallenge.model.Category;
import com.example.ecommercehiringchallenge.repository.CategoryRepository;
import com.example.ecommercehiringchallenge.service.ICategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private Category findCategoryById(Integer categoryId){
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundCategoryException("Bu id ile kategori bulunamadı : " +categoryId));
    }
    @Transactional
    public CategoryResponseDto createCategory(CreateCategoryRequest createCategoryRequest){
        Category saveCategory = new Category();

        saveCategory.setCategoryName(createCategoryRequest.getCategoryName());
        saveCategory.setProducts(new ArrayList<>());
        return new CategoryResponseDto(categoryRepository.save(saveCategory));
    }

    public List<CategoryResponseDto> getAllCategory(){

        return categoryRepository.findAll().stream()
                .map((category) -> new CategoryResponseDto(category))
                .collect(Collectors.toList());
    }

    public CategoryResponseDto getCategoryById(Integer categoryId) {
        return new CategoryResponseDto(findCategoryById(categoryId));
    }

    @Transactional

    public CategoryResponseDto updateCategory(Integer categoryId, UpdateCategoryRequest updateCategoryRequest) {
        Category category = findCategoryById(categoryId);
        category.setCategoryName(updateCategoryRequest.getCategoryName());

        categoryRepository.save(category);
        return new CategoryResponseDto(category);
    }
    @Transactional

    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
