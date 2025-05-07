package com.siparisinhazir.demo.service;

import com.siparisinhazir.demo.dto.VendorRequest;
import com.siparisinhazir.demo.dto.VendorResponse;

import java.util.List;

public interface IVendorService {

    VendorResponse createVendor(VendorRequest request);

    void deleteVendor(Long id);

    List<VendorResponse> getAllVendors();
}
