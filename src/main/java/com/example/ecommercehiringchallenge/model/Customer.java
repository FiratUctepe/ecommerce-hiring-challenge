package com.example.ecommercehiringchallenge.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

import com.example.ecommercehiringchallenge.dto.request.CreateCustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    @Email
    private String email;

    private Integer age;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @Column(name = "orders")
    private List<Order> orders;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @Column(name = "cards")
    private Set<CreditCard> cards;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    //Bu kısmı UserServiseDetail için kullanacağız

    // Kilitli mi değil mi?
    private Boolean isAccountNonLocked;

    // Hesap süresi dolu mu?
    private Boolean isAccountNonExpired;

    // Bilgilerin süresi doldu mu?
    private Boolean isCredentialsNonExpired;

    // Bu hesap kullanılabilir mi?
    private Boolean isEnabled;
}
