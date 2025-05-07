package com.siparisinhazir.demo.controllerr;
import com.siparisinhazir.demo.dto.MenuItemRequest;
import com.siparisinhazir.demo.dto.MenuItemResponse;
import com.siparisinhazir.demo.service.IMenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
@RequiredArgsConstructor
public class MenuItemController {

    private final ThreadLocal<IMenuItemService> menuItemService = new ThreadLocal<IMenuItemService>();

    @PostMapping("/addMenuItem")
    @PreAuthorize("hasRole('ADMIN')")
    public MenuItemResponse addMenuItem(@RequestBody MenuItemRequest request) {
        return menuItemService.get().createMenuItem(request);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public MenuItemResponse updateMenuItem(@PathVariable Long id, @RequestBody MenuItemRequest request) {
        return menuItemService.get().updateMenuItem(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMenuItem(@PathVariable Long id) {
        menuItemService.get().deleteMenuItem(id);
    }

    @GetMapping
    public List<MenuItemResponse> getAllMenuItems() {
        return menuItemService.get().getAllMenuItems();
    }

    @GetMapping("/vendor/{vendorId}")
    public List<MenuItemResponse> getMenuItemsByVendor(@PathVariable Long vendorId) {
        return menuItemService.get().getMenuItemsByVendor(vendorId);
    }
}

