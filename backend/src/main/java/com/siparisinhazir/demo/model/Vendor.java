package com.siparisinhazir.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
