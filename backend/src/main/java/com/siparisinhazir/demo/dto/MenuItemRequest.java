package com.siparisinhazir.demo.dto;

import lombok.Data;

@Data
public class MenuItemRequest {
    private String name;
    private String description;
    private Double price;
    private Long vendorId;
}
