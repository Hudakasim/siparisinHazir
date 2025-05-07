package com.siparisinhazir.demo.service;

import com.siparisinhazir.demo.dto.RegisterRequest;
import com.siparisinhazir.demo.dto.UserResponse;

public interface IUserService {
    UserResponse registerUser(RegisterRequest request);
}
