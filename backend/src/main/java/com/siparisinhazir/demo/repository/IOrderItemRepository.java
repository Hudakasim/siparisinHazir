package com.siparisinhazir.demo.repository;

import com.siparisinhazir.demo.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {
}
