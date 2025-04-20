package com.siparisinhazir.demo.service;

import com.siparisinhazir.demo.dto.LoginRequest;
import com.siparisinhazir.demo.dto.RegisterRequest;
import com.siparisinhazir.demo.dto.UserResponse;

public interface UserService {

    UserResponse register(RegisterRequest request);

    UserResponse login(LoginRequest request);
}
