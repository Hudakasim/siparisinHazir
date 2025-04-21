package com.siparisinhazir.demo.service;

import com.siparisinhazir.demo.dto.RegisterRequest;
import com.siparisinhazir.demo.dto.UserResponse;

public interface UserService {
    UserResponse registerUser(RegisterRequest request);
}
