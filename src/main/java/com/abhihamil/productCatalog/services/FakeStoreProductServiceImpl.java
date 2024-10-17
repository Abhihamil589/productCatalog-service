package com.abhihamil.productCatalog.services;


import com.abhihamil.productCatalog.dtos.FakeStoreProductServiceDTO;
import com.abhihamil.productCatalog.exceptions.NotFoundException;
import com.abhihamil.productCatalog.models.Product;
import com.abhihamil.productCatalog.thirdpartyclients.fakestore.FakeStoreProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    @Autowired
    FakeStoreProductServiceClient fakeStoreProductServiceClient;

    @Override
    public Product getProductById(Long id) throws NotFoundException {
        return fakeStoreProductServiceClient.getProductById(id);
    }

    @Override
    public FakeStoreProductServiceDTO createProduct(FakeStoreProductServiceDTO fakeStoreProductServiceDTO) {
        System.out.println("createProduct");
        return fakeStoreProductServiceClient.createProduct(fakeStoreProductServiceDTO);
    }

    @Override
    public List<FakeStoreProductServiceDTO> getAllProducts() {

        return fakeStoreProductServiceClient.getAllProducts();
    }
}