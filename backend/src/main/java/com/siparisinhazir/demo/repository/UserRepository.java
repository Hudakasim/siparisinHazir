package com.siparisinhazir.demo.repository;

import com.siparisinhazir.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class UserRepository implements JpaRepository<User, Long> {

    // E-posta varsa true döner (register kontrolü için)
    public abstract boolean existsByEmail(String email);

}
