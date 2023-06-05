package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.model.Category;
import com.example.ecommercehiringchallenge.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category){
        Category saveCategory = new Category();

        saveCategory.setCategoryName(category.getCategoryName());
        saveCategory.setProducts(category.getProducts());

        return categoryRepository.save(saveCategory);
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
