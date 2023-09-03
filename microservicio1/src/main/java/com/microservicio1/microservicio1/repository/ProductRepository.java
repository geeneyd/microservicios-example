package com.microservicio1.microservicio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio1.microservicio1.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
