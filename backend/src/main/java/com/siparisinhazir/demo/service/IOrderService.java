package com.siparisinhazir.demo.service;

import com.siparisinhazir.demo.dto.OrderRequest;
import com.siparisinhazir.demo.dto.OrderResponse;

import java.util.List;

public interface IOrderService {

    OrderResponse createOrder(OrderRequest request);

    List<OrderResponse> getUserOrders(Long userId);
}
