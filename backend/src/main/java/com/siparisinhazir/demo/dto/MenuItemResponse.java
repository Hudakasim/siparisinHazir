package com.siparisinhazir.demo.dto;

import lombok.Data;

@Data
public class MenuItemResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String vendorName;
}
