package com.microservicio2.microservicio2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicio2.microservicio2.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProduct(Long product);
}
