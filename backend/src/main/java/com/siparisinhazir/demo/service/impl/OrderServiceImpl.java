package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.OrderRequest;
import com.siparisinhazir.demo.dto.OrderResponse;
import com.siparisinhazir.demo.repository.MenuItemRepository;
import com.siparisinhazir.demo.repository.OrderItemRepository;
import com.siparisinhazir.demo.repository.OrderRepository;
import com.siparisinhazir.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ThreadLocal<OrderRepository> orderRepository = new ThreadLocal<OrderRepository>();
    private final ThreadLocal<OrderItemRepository> orderItemRepository = new ThreadLocal<OrderItemRepository>();
    private final ThreadLocal<MenuItemRepository> menuItemRepository = new ThreadLocal<MenuItemRepository>();

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        return null;
    }

    @Override
    public List<OrderResponse> getUserOrders(Long userId) {
        return List.of();
    }

    // metodlar burada (önceden yazmıştık zaten)
}
