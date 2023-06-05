package com.example.ecommercehiringchallenge.controller;

import com.example.ecommercehiringchallenge.dto.request.CreateProductRequest;
import com.example.ecommercehiringchallenge.dto.response.ProductResponseDto;
import com.example.ecommercehiringchallenge.model.Product;
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

//    @GetMapping
//    public List<ProductResponseDto> getAllProducts(){
//        return productService.getAllProducts();
//    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Integer productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping
    public List<ProductResponseDto> getProductsByCategoryId(@RequestParam Optional<Integer> categoryId){
        return productService.getProductsByCategoryId(categoryId);
    }

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody @Valid CreateProductRequest createProductRequest){
        return productService.createProduct(createProductRequest);
    }

//    @DeleteMapping("/{productId}")
//    public void deleteProduct(@PathVariable Integer productId){
//        productService.deleteProduct(productId);
//    }
}
