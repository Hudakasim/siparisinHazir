package com.siparisinhazir.demo.repository;

import com.siparisinhazir.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // E-posta varsa true döner (register kontrolü için)
    boolean existsByEmail(String email);

}
