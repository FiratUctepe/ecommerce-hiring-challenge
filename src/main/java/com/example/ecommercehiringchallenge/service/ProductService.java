package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.model.Product;
import com.example.ecommercehiringchallenge.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public  Product createProduct(Product product){
        Product saveProduct = new Product();

        saveProduct.setName(product.getName());
        saveProduct.setPrice(product.getPrice());
        saveProduct.setStock(product.getStock());
        saveProduct.setDescription(product.getDescription());

        return productRepository.save(saveProduct);
    }
}
