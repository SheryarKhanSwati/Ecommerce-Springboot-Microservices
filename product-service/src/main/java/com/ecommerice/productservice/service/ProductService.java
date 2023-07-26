package com.ecommerice.productservice.service;

import com.ecommerice.productservice.dto.ProductRequest;
import com.ecommerice.productservice.dto.ProductResponce;

import java.util.List;

public interface ProductService {
    public void createProduct(ProductRequest productRequest);
    public List<ProductResponce> getAllProducts();
}
