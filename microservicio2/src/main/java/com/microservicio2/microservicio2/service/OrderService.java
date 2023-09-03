package com.microservicio2.microservicio2.service;

import java.util.List;

import com.microservicio2.microservicio2.model.Order;

public interface OrderService {
    List<Order> list();
    Order save(Order order);
    List<Order> findByProduct(Long idProduct);
}
