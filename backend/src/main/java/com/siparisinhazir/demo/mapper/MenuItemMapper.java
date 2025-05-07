package com.siparisinhazir.demo.mapper;

import com.siparisinhazir.demo.dto.MenuItemRequest;
import com.siparisinhazir.demo.dto.MenuItemResponse;
import com.siparisinhazir.demo.model.MenuItem;
import com.siparisinhazir.demo.model.Vendor;

public class MenuItemMapper {

    public static MenuItem dtoToMenuItem(MenuItemRequest dto, Vendor vendor) {
        if (dto == null || vendor == null) return null;

        MenuItem menuItem = new MenuItem();
        menuItem.setName(dto.getName());
        menuItem.setDescription(dto.getDescription());
        menuItem.setPrice(dto.getPrice());
        menuItem.setVendor(vendor);
        return menuItem;
    }

    public static MenuItemResponse menuItemToDto(MenuItem menuItem) {
        if (menuItem == null) return null;

        MenuItemResponse dto = new MenuItemResponse();
        dto.setId(menuItem.getId());
        dto.setName(menuItem.getName());
        dto.setDescription(menuItem.getDescription());
        dto.setPrice(menuItem.getPrice());
        dto.setVendorName(menuItem.getVendor().getName());
        return dto;
    }

    public static void updateMenuItemFromDto(MenuItemRequest dto, MenuItem menuItem) {
        if (dto == null || menuItem == null) return;

        if (dto.getName() != null) menuItem.setName(dto.getName());
        if (dto.getDescription() != null) menuItem.setDescription(dto.getDescription());
        if (dto.getPrice() != null) menuItem.setPrice(dto.getPrice());
        // vendor güncellemesi servis katmanında yapılmalı
    }
}