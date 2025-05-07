package com.siparisinhazir.demo.service.impl;

import com.siparisinhazir.demo.dto.VendorRequest;
import com.siparisinhazir.demo.dto.VendorResponse;
import com.siparisinhazir.demo.mapper.VendorMapper;
import com.siparisinhazir.demo.model.Vendor;
import com.siparisinhazir.demo.repository.IVendorRepository;
import com.siparisinhazir.demo.service.IVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements IVendorService {

    @Autowired
    private IVendorRepository vendorRepository;

    @Override
    public VendorResponse createVendor(VendorRequest request) {
        Vendor vendor = VendorMapper.dtoToVendor(request);
        Vendor saved = vendorRepository.save(vendor);
        return VendorMapper.vendorToDto(saved);
    }

    @Override
    public void deleteVendor(Long id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        vendor.ifPresent(vendorRepository::delete);
    }

    @Override
    public List<VendorResponse> getAllVendors() {
        List<Vendor> vendors = vendorRepository.findAll();
        return vendors.stream()
                .map(VendorMapper::vendorToDto)
                .collect(Collectors.toList());
    }
}