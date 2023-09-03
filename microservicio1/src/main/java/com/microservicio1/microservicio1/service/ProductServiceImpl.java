package com.microservicio1.microservicio1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicio1.microservicio1.model.Order;
import com.microservicio1.microservicio1.model.Product;
import com.microservicio1.microservicio1.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> list() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> update(Product product, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void remove(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public List<Order> getOrders(Long idProduct) {
        ResponseEntity<List<Order>> response = restTemplate.exchange( "http://localhost:8082/orders/product/" + idProduct, HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {});
        //List<Order> orders = restTemplate.getForObject("http://localhost:8082/orders/product/"+idProduct, List.class);
        List<Order> orders = response.getBody();
        return orders;
    }

    
}
