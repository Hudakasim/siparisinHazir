package com.siparisinhazir.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vendors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String logoUrl; // örneğin: "/images/coffee-factory.png"
}
