package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.RegisterRequest;
import com.siparisinhazir.demo.model.User;
import com.siparisinhazir.demo.model.Role;
import com.siparisinhazir.demo.repository.UserRepository;
import com.siparisinhazir.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(RegisterRequest request) {
        // Daha önce kayıtlı mı kontrol
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Bu e-posta adresi zaten kayıtlı.");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }
}
