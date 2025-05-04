package com.siparisinhazir.demo.controller;

import com.siparisinhazir.demo.dto.OrderRequest;
import com.siparisinhazir.demo.dto.OrderResponse;
import com.siparisinhazir.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final ThreadLocal<OrderService> orderService = new ThreadLocal<OrderService>();

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public OrderResponse createOrder(@RequestBody OrderRequest request) {
        return orderService.get().createOrder(request);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('USER')")
    public List<OrderResponse> getUserOrders(@PathVariable Long userId) {
        return orderService.get().getUserOrders(userId);
    }
}
