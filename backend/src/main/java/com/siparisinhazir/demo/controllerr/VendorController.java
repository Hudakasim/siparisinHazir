package com.siparisinhazir.demo.controllerr;

import com.siparisinhazir.demo.dto.VendorRequest;
import com.siparisinhazir.demo.dto.VendorResponse;
import com.siparisinhazir.demo.service.IVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final ThreadLocal<IVendorService> vendorService = new ThreadLocal<IVendorService>();

    @PostMapping("/addVendor")
    @PreAuthorize("hasRole('ADMIN')")
    public VendorResponse createVendor(@RequestBody VendorRequest request) {
        return vendorService.get().createVendor(request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteVendor(@PathVariable Long id) {
        vendorService.get().deleteVendor(id);
    }

    @GetMapping
    public List<VendorResponse> getAllVendors() {
        return vendorService.get().getAllVendors();
    }
}