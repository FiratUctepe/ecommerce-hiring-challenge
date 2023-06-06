package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.dto.request.CreateProductRequest;
import com.example.ecommercehiringchallenge.dto.request.UpdateProductRequest;
import com.example.ecommercehiringchallenge.dto.response.ProductResponseDto;
import com.example.ecommercehiringchallenge.exception.NotFoundProductException;
import com.example.ecommercehiringchallenge.model.Category;
import com.example.ecommercehiringchallenge.model.Product;
import com.example.ecommercehiringchallenge.repository.CategoryRepository;
import com.example.ecommercehiringchallenge.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    private Product findProduct(Integer productId){
        return productRepository.findById(productId)
                            .orElseThrow(() -> new NotFoundProductException("Bu id ile bir ürün bulunamamıştır : " + productId));
    }

    public ProductResponseDto getProductById(Integer productId) {
        Product product = findProduct(productId);
        return new ProductResponseDto(product);
    }
    public ProductResponseDto createProduct(CreateProductRequest createProductRequest){
        Product saveProduct = new Product();
        Category category = categoryRepository.findByCategoryName(createProductRequest.getCategoryName())
                                              .orElse(null);

        saveProduct.setProductName(createProductRequest.getProductName());
        saveProduct.setPrice(createProductRequest.getPrice());
        saveProduct.setStock(createProductRequest.getStock());
        saveProduct.setDescription(createProductRequest.getDescription());
        saveProduct.setCategory(category);

        productRepository.save(saveProduct);
        return new ProductResponseDto(saveProduct);
    }

    public List<ProductResponseDto> getAllProductsOrByCategoryId( Optional<Integer> categoryId) {

        if (categoryId.isPresent()){
            List<Product> products = productRepository.findProductByCategory_Id(categoryId.get());
            return products.stream()
                    .map((product) -> new ProductResponseDto(product))
                    .collect(Collectors.toList());
        }
        return productRepository.findAll().stream()
                                .map((product) -> new ProductResponseDto(product))
                                .collect(Collectors.toList());
    }

    public void deleteProduct(Integer productId) {
        Product product = findProduct(productId);
        productRepository.delete(product);
    }

    public ProductResponseDto updateProduct(Integer productId,UpdateProductRequest updateProductRequest) {
        Product product = findProduct(productId);

        product.setProductName(updateProductRequest.getProductName());
        product.setPrice(updateProductRequest.getPrice());
        product.setStock(updateProductRequest.getStock());
        product.setDescription(updateProductRequest.getDescription());

        productRepository.save(product);
        return new ProductResponseDto(product);
    }
}
