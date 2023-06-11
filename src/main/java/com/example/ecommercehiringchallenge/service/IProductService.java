package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.dto.request.CreateProductRequest;
import com.example.ecommercehiringchallenge.dto.request.UpdateProductRequest;
import com.example.ecommercehiringchallenge.dto.response.ProductResponseDto;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    public ProductResponseDto createProduct(CreateProductRequest createProductRequest);
    public List<ProductResponseDto> getAllProductsOrByCategoryId(Optional<Integer> categoryId);
    public void deleteProduct(Integer productId);
    public ProductResponseDto updateProduct(Integer productId, UpdateProductRequest updateProductRequest);

}
