package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.OrderRequest;
import com.siparisinhazir.demo.dto.OrderResponse;
import com.siparisinhazir.demo.repository.IMenuItemRepository;
import com.siparisinhazir.demo.repository.IOrderItemRepository;
import com.siparisinhazir.demo.repository.IOrderRepository;
import com.siparisinhazir.demo.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final ThreadLocal<IOrderRepository> orderRepository = new ThreadLocal<IOrderRepository>();
    private final ThreadLocal<IOrderItemRepository> orderItemRepository = new ThreadLocal<IOrderItemRepository>();
    private final ThreadLocal<IMenuItemRepository> menuItemRepository = new ThreadLocal<IMenuItemRepository>();

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
