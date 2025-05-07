package com.siparisinhazir.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Where(clause="deleted=false")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean deleted=false;

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

    public void setUsername(String ignoredUsername) {
    }
}
