package com.siparisinhazir.demo.model;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
