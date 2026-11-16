package com.dk.order_service.dto;

import java.math.BigDecimal;

public record CreateOrderRequest(String customerId, BigDecimal amount, String currency) {
}