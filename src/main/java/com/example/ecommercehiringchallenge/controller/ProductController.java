package com.example.ecommercehiringchallenge.controller;

import com.example.ecommercehiringchallenge.model.Product;
import com.example.ecommercehiringchallenge.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/product")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody @Valid Product product){
        return productService.createProduct(product);
    }
}
