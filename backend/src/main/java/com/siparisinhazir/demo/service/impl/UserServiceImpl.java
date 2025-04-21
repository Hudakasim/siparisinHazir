package com.siparisinhazir.demo.service.impl;
import com.siparisinhazir.demo.dto.RegisterRequest;
import com.siparisinhazir.demo.dto.UserResponse;
import com.siparisinhazir.demo.repository.UserRepository;
import com.siparisinhazir.demo.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AtomicReference<UserRepository> userRepository = new AtomicReference<UserRepository>();
    private final AtomicReference<PasswordEncoder> passwordEncoder = new AtomicReference<PasswordEncoder>();

    @Override
    public UserResponse registerUser(RegisterRequest request) {
        return null;
    }
}
