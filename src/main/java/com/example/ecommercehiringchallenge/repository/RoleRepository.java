package com.example.ecommercehiringchallenge.repository;

import com.example.ecommercehiringchallenge.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
