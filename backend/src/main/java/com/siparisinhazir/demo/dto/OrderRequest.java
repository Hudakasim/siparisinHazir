package com.siparisinhazir.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<OrderItemRequest> orderItems;

    private Long userId;
}
