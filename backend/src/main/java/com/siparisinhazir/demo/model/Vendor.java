package com.siparisinhazir.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "vendors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Örn: "Coffee Factory", "Yesen Burger", "Aker"
    @Column(nullable = false)
    private String name;

    // Logo görseli için URL
    private String logoUrl;

    // İsteğe bağlı: Kategori (Kafe, Restoran, Tatlıcı, vs.)
    private String category;

    // Bu kafenin tüm ürünleri
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;
}
