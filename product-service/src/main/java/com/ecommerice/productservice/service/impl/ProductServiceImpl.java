package com.ecommerice.productservice.service.impl;

import com.ecommerice.productservice.Repository.ProductRepositoty;
import com.ecommerice.productservice.dto.ProductRequest;
import com.ecommerice.productservice.dto.ProductResponce;
import com.ecommerice.productservice.entities.Product;
import com.ecommerice.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositoty productRepositoty;
    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()

                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
             productRepositoty.save(product);

        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponce> getAllProducts() {
        List<Product> products = productRepositoty.findAll();

       return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }
    private ProductResponce mapToProductResponse(Product product){
        return ProductResponce.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
