package com.example.ecommercehiringchallenge.controller;

import com.example.ecommercehiringchallenge.dto.request.CreateProductRequest;
import com.example.ecommercehiringchallenge.dto.request.UpdateProductRequest;
import com.example.ecommercehiringchallenge.dto.response.ProductResponseDto;
import com.example.ecommercehiringchallenge.service.ProductService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/product")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProductsOrByCategoryId(@RequestParam Optional<Integer> categoryId){
        return ResponseEntity.ok(productService.getAllProductsOrByCategoryId(categoryId) );
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Integer productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest){
        return new ResponseEntity<>(productService.createProduct(createProductRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Integer productId,
                                                            @RequestBody @Valid UpdateProductRequest updateProductRequest){
        return ResponseEntity.ok(productService.updateProduct(productId,updateProductRequest));
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Integer productId){
        productService.deleteProduct(productId);
    }
}
