package com.abhihamil.productCatalog.thirdpartyclients.fakestore;

import com.abhihamil.productCatalog.dtos.FakeStoreProductServiceDTO;
import com.abhihamil.productCatalog.exceptions.NotFoundException;
import com.abhihamil.productCatalog.models.Product;
import com.abhihamil.productCatalog.thirdpartyclients.ThirdPartyProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductServiceClient implements ThirdPartyProductService {
    @Value("${fakeStore.api.base.url}")
    private String fakeStoreBaseUrl;
    @Value("${fakeStore.api.product.url}")
    private String fakeStoreProductUrl;

    private String productsResource;
    private String productsResourceById;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @PostConstruct
    public void init() {
        productsResourceById = fakeStoreBaseUrl + fakeStoreProductUrl + "/{id}";
        productsResource = fakeStoreBaseUrl + fakeStoreProductUrl;
    }

    @Override
    public Product getProductById(Long id) throws NotFoundException {
        System.out.println("inside getProductById " + productsResourceById);

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductServiceDTO> fakeStoreProductServiceDTOResponseEntity = restTemplate.getForEntity(productsResourceById, FakeStoreProductServiceDTO.class, id);
        FakeStoreProductServiceDTO fakeStoreProductServiceDTOResponseEntityBody = fakeStoreProductServiceDTOResponseEntity.getBody();


        Optional<FakeStoreProductServiceDTO> optionalFakeStoreProductServiceDTO = Optional.ofNullable(fakeStoreProductServiceDTOResponseEntityBody);

        FakeStoreProductServiceDTO fakeStoreProductServiceDTO = optionalFakeStoreProductServiceDTO.orElseThrow(() -> new NotFoundException("Product not found for the " + id));

        Product product = new Product();
        product.setTitle(fakeStoreProductServiceDTO.getTitle());
        product.setPrice(fakeStoreProductServiceDTO.getPrice());

        return product;
    }

    @Override
    public FakeStoreProductServiceDTO createProduct(FakeStoreProductServiceDTO fakeStoreProductServiceDTO) {
        System.out.println("createProduct " + productsResource);

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductServiceDTO> fakeStoreProductServiceDTOResponseEntity = restTemplate.postForEntity(productsResource, fakeStoreProductServiceDTO, FakeStoreProductServiceDTO.class);
        return fakeStoreProductServiceDTOResponseEntity.getBody();
    }

    @Override
    public List<FakeStoreProductServiceDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductServiceDTO[]> fakeStoreAllProducts = restTemplate.getForEntity(productsResource, FakeStoreProductServiceDTO[].class);
        List<FakeStoreProductServiceDTO> fakeStoreAllProductList = Arrays.stream(fakeStoreAllProducts.getBody()).toList();

        return fakeStoreAllProductList;
    }
}
