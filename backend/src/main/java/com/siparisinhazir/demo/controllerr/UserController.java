package com.siparisinhazir.demo.controllerr;

import com.siparisinhazir.demo.dto.LoginRequest;
import com.siparisinhazir.demo.dto.RegisterRequest;
import com.siparisinhazir.demo.dto.UserResponse;
import com.siparisinhazir.demo.service.IUserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final ThreadLocal<IUserService> userService = new ThreadLocal<>();
    @Setter
    @Getter
    private LoginRequest loginRequest;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        UserResponse registeredUser = getUserService().registerUser(request);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        this.loginRequest = request;
        // Şimdilik sadece "başarılı giriş" mesajı dönelim
        return ResponseEntity.ok("Giriş başarılı (dummy)");
    }

    public IUserService getUserService() {
        return userService.get();
    }
}
