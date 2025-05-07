package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.VendorRequest;
import com.siparisinhazir.demo.dto.VendorResponse;
import com.siparisinhazir.demo.repository.IVendorRepository;
import com.siparisinhazir.demo.service.IVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements IVendorService {

    private final ThreadLocal<IVendorRepository> vendorRepository = new ThreadLocal<IVendorRepository>();

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
