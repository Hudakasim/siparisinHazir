package com.siparisinhazir.demo.mapper;

import com.siparisinhazir.demo.dto.UserResponse;
import com.siparisinhazir.demo.model.User;

public class UserMapper {

    public static UserResponse userToDto(User user) {
        if (user == null) return null;

        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole()); // enum ise
        return dto;
    }

    public static User dtoToUser(UserResponse dto) {
        if (dto == null) return null;

        User user = new User();
        user.setId(dto.getId());
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        // Role set edilemez çünkü string geldi, ayrı enum dönüşüm gerekir
        return user;
    }

    public static void updateUserFromDto(UserResponse dto, User user) {
        if (dto == null || user == null) return;

        if (dto.getFullName() != null) user.setFullName(dto.getFullName());
        if (dto.getEmail() != null) user.setEmail(dto.getEmail());
        // Role güncellemesi ayrıca düşünülmeli, enum kontrolü yapılmalı
    }
}

