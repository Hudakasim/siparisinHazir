package com.siparisinhazir.demo.repository;

import com.siparisinhazir.demo.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByVendorId(Long vendorId);
}