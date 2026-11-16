package com.dk.order_service.exception;

import org.springframework.http.HttpStatus;


public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Order not found: " + id);
    }
}