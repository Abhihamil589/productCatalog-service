package com.abhihamil.productCatalog.controllers;

import com.abhihamil.productCatalog.dtos.ErrorDataDTO;
import com.abhihamil.productCatalog.dtos.FakeStoreProductServiceDTO;
import com.abhihamil.productCatalog.exceptions.NotFoundException;
import com.abhihamil.productCatalog.models.Product;
import com.abhihamil.productCatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<FakeStoreProductServiceDTO>> getAllProducts() {

        List<FakeStoreProductServiceDTO> fakeStoreProductServiceDTOS = productService.getAllProducts();
        return new ResponseEntity<>(fakeStoreProductServiceDTOS, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }


    @DeleteMapping("{id}")
    public void deleteProductById() {
    }

    @PostMapping
    public ResponseEntity<FakeStoreProductServiceDTO> createProduct(@RequestBody FakeStoreProductServiceDTO fakeStoreProductServiceDTO) {

        FakeStoreProductServiceDTO fakeStoreProductServiceDTO1 = productService.createProduct(fakeStoreProductServiceDTO);
        return new ResponseEntity<>(fakeStoreProductServiceDTO1, HttpStatus.CREATED);


    }

    @PutMapping("{id}")
    public void updateProductById() {
    }
}
