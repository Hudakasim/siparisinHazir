package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.MenuItemRequest;
import com.siparisinhazir.demo.dto.MenuItemResponse;
import com.siparisinhazir.demo.repository.IMenuItemRepository;
import com.siparisinhazir.demo.repository.IVendorRepository;
import com.siparisinhazir.demo.service.IMenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements IMenuItemService {

    private final ThreadLocal<IMenuItemRepository> menuItemRepository = new ThreadLocal<IMenuItemRepository>();
    private final ThreadLocal<IVendorRepository> vendorRepository = new ThreadLocal<IVendorRepository>();

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
