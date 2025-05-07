package com.siparisinhazir.demo.mapper;

import com.siparisinhazir.demo.dto.MenuItemRequest;
import com.siparisinhazir.demo.dto.MenuItemResponse;
import com.siparisinhazir.demo.model.MenuItem;
import com.siparisinhazir.demo.model.Vendor;

public class MenuItemMapper {

    public static MenuItem toEntity(MenuItemRequest dto, Vendor vendor) {
        MenuItem entity = new MenuItem();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setVendor(vendor);
        return entity;

    }

    public static MenuItemResponse toDto(MenuItem entity) {
        MenuItemResponse dto = new MenuItemResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setVendorName(entity.getVendor().getName());
        return dto;
    }
}