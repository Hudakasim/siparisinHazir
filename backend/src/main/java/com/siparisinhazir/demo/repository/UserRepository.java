package com.siparisinhazir.demo.repository;

import com.siparisinhazir.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // E-posta varsa true döner (register kontrolü için)
    boolean existsByEmail(String email);

    // Giriş yapmak için kullanıcıyı email ile bulur
    Optional<User> findByEmail(String email);
}
