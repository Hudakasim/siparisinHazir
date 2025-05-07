package com.siparisinhazir.demo.mapper;

import com.siparisinhazir.demo.dto.VendorResponse;
import com.siparisinhazir.demo.model.Vendor;

public class VendorMapper {

    public static Vendor dtoToVendor(VendorResponse dto) {
        if (dto == null) return null;

        Vendor vendor = new Vendor();
        vendor.setId(dto.getId());
        vendor.setName(dto.getName());
        return vendor;
    }

    public static VendorResponse vendorToDto(Vendor vendor) {
        if (vendor == null) return null;

        VendorResponse dto = new VendorResponse();
        dto.setId(vendor.getId());
        dto.setName(vendor.getName());
        return dto;
    }

    public static void updateVendorFromDto(VendorResponse dto, Vendor vendor) {
        if (dto == null || vendor == null) return;

        if (dto.getName() != null) {
            vendor.setName(dto.getName());
        }
    }
}
