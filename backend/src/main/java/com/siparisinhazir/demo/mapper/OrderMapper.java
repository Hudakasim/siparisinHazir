package com.siparisinhazir.demo.mapper;

import com.siparisinhazir.demo.dto.OrderRequest;
import com.siparisinhazir.demo.dto.OrderResponse;
import com.siparisinhazir.demo.model.Order;
import com.siparisinhazir.demo.model.OrderItem;
import com.siparisinhazir.demo.model.OrderStatus;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static Order dtoToOrder(OrderRequest dto, List<OrderItem> orderItems) {
        if (dto == null || orderItems == null) return null;

        Order order = new Order();
        order.setStatus(OrderStatus.PENDING); // varsayılan bir başlangıç durumu
        order.setOrderItems(orderItems);
        return order;
    }

    public static OrderResponse orderToDto(Order order) {
        if (order == null) return null;

        OrderResponse dto = new OrderResponse();
        dto.setId(order.getId());
        dto.setStatus(order.getStatus().name());

        if (order.getOrderItems() != null) {
            dto.setOrderItems(
                    order.getOrderItems().stream()
                            .map(OrderItemMapper::orderItemToDto)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }

    public static void updateOrderFromDto(OrderRequest dto, Order order, List<OrderItem> orderItems) {
        if (dto == null || order == null || orderItems == null) return;

        order.setOrderItems(orderItems);
        // Statü dışarıdan DTO ile değiştirilmiyor, backend'de iş kurallarına göre güncellenir
    }
}










