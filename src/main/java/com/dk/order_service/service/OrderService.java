package com.dk.order_service.service;

import com.dk.order_service.domain.Order;
import com.dk.order_service.dto.CreateOrderRequest;
import com.dk.order_service.dto.OrderResponse;
import com.dk.order_service.exception.OrderNotFoundException;
import com.dk.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderResponse createOrder(CreateOrderRequest request) {
        Order order = new Order(request.customerId(), request.amount(), request.currency());
        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return toResponse(order);
    }

    private OrderResponse toResponse(Order order) {
        return new OrderResponse(order.getId(), order.getCustomerId(), order.getAmount(),
                order.getCurrency(), order.getStatus(), order.getCreatedAt());
    }
}