package com.siparisinhazir.demo.controller;

import com.siparisinhazir.demo.dto.MenuItemRequest;
import com.siparisinhazir.demo.dto.MenuItemResponse;
import com.siparisinhazir.demo.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MenuItemResponse addMenuItem(@RequestBody MenuItemRequest request) {
        return menuItemService.createMenuItem(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public MenuItemResponse updateMenuItem(@PathVariable Long id, @RequestBody MenuItemRequest request) {
        return menuItemService.updateMenuItem(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
    }

    @GetMapping
    public List<MenuItemResponse> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/vendor/{vendorId}")
    public List<MenuItemResponse> getMenuItemsByVendor(@PathVariable Long vendorId) {
        return menuItemService.getMenuItemsByVendor(vendorId);
    }
}
