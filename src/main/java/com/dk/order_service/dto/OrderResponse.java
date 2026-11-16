package com.dk.order_service.dto;

import com.dk.order_service.domain.OrderStatus;
import java.math.BigDecimal;
import java.time.Instant;

public record OrderResponse(Long id, String customerId, BigDecimal amount,
                            String currency, OrderStatus status, Instant createdAt) {
}