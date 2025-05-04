package com.siparisinhazir.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private String status;
    private List<OrderItemResponse> orderItems;
}
