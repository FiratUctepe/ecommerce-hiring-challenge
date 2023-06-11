package com.example.ecommercehiringchallenge.security;

import com.example.ecommercehiringchallenge.model.Customer;
import com.example.ecommercehiringchallenge.model.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class CustomerUserDetails implements UserDetails {
    private Customer customer;

    private Set<GrantedAuthority> roles;

    public CustomerUserDetails(Customer customer) {
        this.customer = customer;
        this.roles = customer.getRoles().stream()
                        .map((role) -> new SimpleGrantedAuthority(role.getRoleName()))
                        .collect(Collectors.toSet());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return roles;
    }

    @Override
    public String getUsername() {
        return customer.getUserName();
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return customer.getIsAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked(){
        return customer.getIsAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return customer.getIsCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return customer.getIsEnabled();
    }


}
