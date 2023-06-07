package com.example.ecommercehiringchallenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private Integer age;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade = CascadeType.ALL)
    @Column(name = "orders")
    private List<Order> orders;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
