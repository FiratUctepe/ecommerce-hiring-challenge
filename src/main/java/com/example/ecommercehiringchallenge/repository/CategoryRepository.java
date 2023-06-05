package com.example.ecommercehiringchallenge.repository;

import com.example.ecommercehiringchallenge.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
