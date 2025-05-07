package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.OrderRequest;
import com.siparisinhazir.demo.dto.OrderResponse;
import com.siparisinhazir.demo.dto.OrderItemRequest;
import com.siparisinhazir.demo.mapper.OrderItemMapper;
import com.siparisinhazir.demo.mapper.OrderMapper;
import com.siparisinhazir.demo.model.*;
import com.siparisinhazir.demo.repository.IOrderItemRepository;
import com.siparisinhazir.demo.repository.IOrderRepository;
import com.siparisinhazir.demo.repository.IMenuItemRepository;
import com.siparisinhazir.demo.repository.UserRepository;
import com.siparisinhazir.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IOrderItemRepository orderItemRepository;

    @Autowired
    private IMenuItemRepository menuItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        // Kullanıcıyı bul
        User user = userRepository.findById(request.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found"));

        // OrderItem listesi oluştur
        List<OrderItem> orderItems = request.getOrderItems().stream().map(itemReq -> {
            MenuItem menuItem = menuItemRepository.findById(itemReq.getMenuItemId()).orElseThrow(() ->
                    new RuntimeException("MenuItem not found"));
            return OrderItemMapper.dtoToOrderItem(itemReq, menuItem);
        }).collect(Collectors.toList());

        // Siparişi oluştur
        Order order = OrderMapper.dtoToOrder(request, orderItems);
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);

        // Order'ı ve içindeki OrderItem'ları kaydet
        Order savedOrder = orderRepository.save(order);
        orderItems.forEach(item -> item.setOrder(savedOrder));
        orderItemRepository.saveAll(orderItems);

        return OrderMapper.orderToDto(savedOrder);
    }

    @Override
    public List<OrderResponse> getUserOrders(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User not found"));

        List<Order> orders = orderRepository.findByUserId(user.getId());

        return orders.stream()
                .map(OrderMapper::orderToDto)
                .collect(Collectors.toList());
    }
}