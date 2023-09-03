package com.microservicio2.microservicio2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio2.microservicio2.model.Order;
import com.microservicio2.microservicio2.service.OrderService;

@RestController
@RequestMapping(path = "orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> list() {
        return orderService.list();
    }

    @GetMapping("/product/{idProduct}")
    public ResponseEntity<List<Order>> findByProduct(@PathVariable("idProduct") Long idProduct) {
        List<Order> orders = orderService.findByProduct(idProduct);
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order newOrder = orderService.save(order);
        return ResponseEntity.ok(newOrder);
    }
}
