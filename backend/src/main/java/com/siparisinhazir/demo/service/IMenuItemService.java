package com.siparisinhazir.demo.service;

import com.siparisinhazir.demo.dto.MenuItemRequest;
import com.siparisinhazir.demo.dto.MenuItemResponse;

import java.util.List;

public interface IMenuItemService {

    MenuItemResponse createMenuItem(MenuItemRequest request);

    MenuItemResponse updateMenuItem(Long id, MenuItemRequest request);

    void deleteMenuItem(Long id);

    List<MenuItemResponse> getAllMenuItems();

    List<MenuItemResponse> getMenuItemsByVendor(Long vendorId);
}
