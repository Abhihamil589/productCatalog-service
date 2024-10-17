package com.abhihamil.productCatalog.dtos;

import com.abhihamil.productCatalog.models.Category;
import lombok.Data;

@Data
public class FakeStoreProductServiceDTO {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

}
