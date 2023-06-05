package com.example.ecommercehiringchallenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String categoryName;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products;;
}
