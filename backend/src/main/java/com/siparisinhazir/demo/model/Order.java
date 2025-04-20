package com.siparisinhazir.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Kullanıcıyla ilişkilendir
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Siparişteki ürünler (ara tablo gibi çalışacak: OrderItem)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

    // Ek bilgi
    private String note;
    private String deliveryTime;

    private double totalAmount;

    private LocalDateTime createdAt = LocalDateTime.now();
}
