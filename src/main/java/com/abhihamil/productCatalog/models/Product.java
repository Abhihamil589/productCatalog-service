package com.abhihamil.productCatalog.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;


}
