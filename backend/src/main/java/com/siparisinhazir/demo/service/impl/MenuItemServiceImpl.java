package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.MenuItemRequest;
import com.siparisinhazir.demo.dto.MenuItemResponse;
import com.siparisinhazir.demo.mapper.MenuItemMapper;
import com.siparisinhazir.demo.model.MenuItem;
import com.siparisinhazir.demo.model.Vendor;
import com.siparisinhazir.demo.repository.IMenuItemRepository;
import com.siparisinhazir.demo.repository.IVendorRepository;
import com.siparisinhazir.demo.service.IMenuItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements IMenuItemService {

    private final IMenuItemRepository menuItemRepository;

    private final IVendorRepository vendorRepository;

    public MenuItemServiceImpl(IMenuItemRepository menuItemRepository, IVendorRepository vendorRepository) {
        this.menuItemRepository = menuItemRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public MenuItemResponse createMenuItem(MenuItemRequest request) {
        Vendor vendor = vendorRepository.findById(request.getVendorId()).orElse(null);
        if (vendor == null) {
            throw new RuntimeException("Vendor not found");
        }

        MenuItem menuItem = MenuItemMapper.dtoToMenuItem(request, vendor);
        MenuItem saved = menuItemRepository.save(menuItem);
        return MenuItemMapper.menuItemToDto(saved);
    }

    @Override
    public MenuItemResponse updateMenuItem(Long id, MenuItemRequest request) {
        Optional<MenuItem> optional = menuItemRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Menu item not found");
        }

        MenuItem menuItem = optional.get();
        MenuItemMapper.updateMenuItemFromDto(request, menuItem);

        vendorRepository.findById(request.getVendorId()).ifPresent(vendor -> menuItem.setVendor(vendor));

        MenuItem updated = menuItemRepository.save(menuItem);
        return MenuItemMapper.menuItemToDto(updated);
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }

    @Override
    public List<MenuItemResponse> getAllMenuItems() {
        List<MenuItem> items = menuItemRepository.findAll();
        return items.stream()
                .map(MenuItemMapper::menuItemToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuItemResponse> getMenuItemsByVendor(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId).orElse(null);
        if (vendor == null) {
            throw new RuntimeException("Vendor not found");
        }

        List<MenuItem> items = menuItemRepository.findByVendorId(vendor.getId());
        return items.stream()
                .map(MenuItemMapper::menuItemToDto)
                .collect(Collectors.toList());
    }
}