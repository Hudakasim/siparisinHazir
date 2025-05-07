package com.siparisinhazir.demo.repository;

import com.siparisinhazir.demo.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVendorRepository extends JpaRepository<Vendor, Long> {
}
