package com.siparisinhazir.demo.mapper;

import com.siparisinhazir.demo.dto.OrderItemRequest;
import com.siparisinhazir.demo.dto.OrderItemResponse;
import com.siparisinhazir.demo.model.MenuItem;
import com.siparisinhazir.demo.model.OrderItem;

public class OrderItemMapper {

    public static OrderItem dtoToOrderItem(OrderItemRequest dto, MenuItem menuItem) {
        if (dto == null || menuItem == null) return null;

        OrderItem orderItem = new OrderItem();
        orderItem.setMenuItem(menuItem);
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setPrice(menuItem.getPrice()); // varsayım: toplam fiyat = birim * adet
        return orderItem;
    }

    public static OrderItemResponse orderItemToDto(OrderItem orderItem) {
        if (orderItem == null) return null;

        OrderItemResponse dto = new OrderItemResponse();
        dto.setMenuItemName(orderItem.getMenuItem().getName());
        dto.setQuantity(orderItem.getQuantity());
        dto.setPrice(orderItem.getPrice());
        return dto;
    }

    public static void updateOrderItemFromDto(OrderItemRequest dto, OrderItem orderItem) {
        if (dto == null || orderItem == null) return;

        if (dto.getQuantity() != null) {
            orderItem.setQuantity(dto.getQuantity());
            orderItem.setPrice(orderItem.getMenuItem().getPrice() * dto.getQuantity());
        }
    }
}