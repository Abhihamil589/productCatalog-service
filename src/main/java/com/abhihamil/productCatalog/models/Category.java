package com.abhihamil.productCatalog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends BaseModel {
    @Column
    private String name;
    @OneToMany
    private List<Product> productList;
 // F12832

}
