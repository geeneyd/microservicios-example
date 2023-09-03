package com.microservicio1.microservicio1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio1.microservicio1.model.Order;
import com.microservicio1.microservicio1.model.Product;
import com.microservicio1.microservicio1.service.ProductService;

@RestController
@RequestMapping(path = "products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> list() {
        return productService.list();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("orders/{idProduct}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable("idProduct") Long idProduct) {
        //Product product = productService.findById(idProduct);
        List<Order> orders = productService.getOrders(idProduct);
        return ResponseEntity.ok(orders);
    }

}
