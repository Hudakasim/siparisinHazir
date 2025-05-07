package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.RegisterRequest;
import com.siparisinhazir.demo.dto.UserResponse;
import com.siparisinhazir.demo.mapper.UserMapper;
import com.siparisinhazir.demo.model.Role;
import com.siparisinhazir.demo.model.User;
import com.siparisinhazir.demo.repository.UserRepository;
import com.siparisinhazir.demo.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse registerUser(RegisterRequest request) {
        // Yeni kullanıcıyı oluştur
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(String.valueOf(Role.USER)); // Default rol veriyoruz

        // Veritabanına kaydet
        User savedUser = userRepository.save(user);

        // DTO'ya dönüştürüp döndür
        return UserMapper.userToDto(savedUser);
    }
}
