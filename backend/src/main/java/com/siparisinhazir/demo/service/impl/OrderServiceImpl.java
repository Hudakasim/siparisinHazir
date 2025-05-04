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
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final MenuItemRepository menuItemRepository;

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
