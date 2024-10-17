package com.abhihamil.productCatalog.services;

import com.abhihamil.productCatalog.dtos.FakeStoreProductServiceDTO;
import com.abhihamil.productCatalog.exceptions.NotFoundException;
import com.abhihamil.productCatalog.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws NotFoundException;

    FakeStoreProductServiceDTO createProduct(FakeStoreProductServiceDTO fakeStoreProductServiceDTO);


    List<FakeStoreProductServiceDTO> getAllProducts();
}
