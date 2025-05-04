package com.siparisinhazir.demo.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Long menuItemId;
    private Integer quantity;
}
