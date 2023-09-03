package com.microservicio1.microservicio1.model;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
    private Long id;
    private Date dateCreate;
    private Long product;
}
