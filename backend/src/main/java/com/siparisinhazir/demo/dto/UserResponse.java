package com.siparisinhazir.demo.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String fullName;
    private String email;
    private String role;
}
