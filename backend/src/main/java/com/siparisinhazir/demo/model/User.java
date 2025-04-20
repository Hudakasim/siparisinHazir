package com.siparisinhazir.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tam adı (full name) — görünen ad
    @Column(nullable = false)
    private String fullName;

    // Email hem giriş için kullanılır hem de unique olmalı
    @Column(nullable = false, unique = true)
    private String email;

    // Şifre (şifrelenmiş olarak saklanacak!)
    @Column(nullable = false)
    private String password;

    // Kullanıcı rolü: "USER", "ADMIN" gibi
    @Column(nullable = false)
    private String role;
}
