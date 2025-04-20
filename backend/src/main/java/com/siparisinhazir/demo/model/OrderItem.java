package com.siparisinhazir.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Sipariş ilişkisi
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Sipariş edilen ürün
    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;

    // Adet
    private int quantity;

    // Opsiyonel: Boyut (Small, Medium, Large gibi)
    private String size;

    // Opsiyonel: Ekstra malzemeler — metin olarak tutulabilir
    private String extras;

    // Ürün başına toplam fiyat (quantity × unitPrice hesaplanarak set edilebilir)
    private double itemTotal;
}
