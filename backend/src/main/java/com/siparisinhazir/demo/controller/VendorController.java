package com.siparisinhazir.demo.controller;

import com.siparisinhazir.demo.dto.VendorRequest;
import com.siparisinhazir.demo.dto.VendorResponse;
import com.siparisinhazir.demo.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public VendorResponse createVendor(@RequestBody VendorRequest request) {
        return vendorService.createVendor(request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
    }

    @GetMapping
    public List<VendorResponse> getAllVendors() {
        return vendorService.getAllVendors();
    }
}
