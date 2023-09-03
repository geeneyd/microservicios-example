package com.microservicio1.microservicio1.service;

import java.util.List;
import java.util.Optional;

import com.microservicio1.microservicio1.model.Order;
import com.microservicio1.microservicio1.model.Product;

public interface ProductService {
    List<Product> list();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> update(Product product, Long id);
    void remove(Long id);
    List<Order> getOrders(Long idProduct);
}
