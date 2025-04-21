package com.siparisinhazir.demo.controller;

import com.siparisinhazir.demo.dto.LoginRequest;
import com.siparisinhazir.demo.dto.RegisterRequest;
import com.siparisinhazir.demo.dto.UserResponse;
import com.siparisinhazir.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        UserResponse registeredUser = userService.registerUser(request);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // Şimdilik sadece "başarılı giriş" mesajı dönelim
        return ResponseEntity.ok("Giriş başarılı (dummy)");
    }
}
