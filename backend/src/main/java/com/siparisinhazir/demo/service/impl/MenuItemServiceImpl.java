package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.MenuItemRequest;
import com.siparisinhazir.demo.dto.MenuItemResponse;
import com.siparisinhazir.demo.repository.MenuItemRepository;
import com.siparisinhazir.demo.repository.VendorRepository;
import com.siparisinhazir.demo.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final VendorRepository vendorRepository;

    @Override
    public MenuItemResponse createMenuItem(MenuItemRequest request) {
        return null;
    }

    @Override
    public MenuItemResponse updateMenuItem(Long id, MenuItemRequest request) {
        return null;
    }

    @Override
    public void deleteMenuItem(Long id) {

    }

    @Override
    public List<MenuItemResponse> getAllMenuItems() {
        return List.of();
    }

    @Override
    public List<MenuItemResponse> getMenuItemsByVendor(Long vendorId) {
        return List.of();
    }

    // metodlar burada (önceden yazmıştık zaten)
}
