package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.VendorRequest;
import com.siparisinhazir.demo.dto.VendorResponse;
import com.siparisinhazir.demo.repository.VendorRepository;
import com.siparisinhazir.demo.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final ThreadLocal<VendorRepository> vendorRepository = new ThreadLocal<VendorRepository>();

    @Override
    public VendorResponse createVendor(VendorRequest request) {
        return null;
    }

    @Override
    public void deleteVendor(Long id) {

    }

    @Override
    public List<VendorResponse> getAllVendors() {
        return List.of();
    }

    // metodlar burada (önceden yazmıştık zaten)
}
