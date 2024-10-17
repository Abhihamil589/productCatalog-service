package com.abhihamil.productCatalog.dtos;

import lombok.Data;

@Data
public class GenericFakeStoreProductServiceDTO {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

}
