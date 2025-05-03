package com.fou.example.nosqlcrud.service;

import com.fou.example.nosqlcrud.domain.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(final Product product);

    List<Product> getAllProducts(final String sort);

    Product getProductById(final String id);

    Product updateProduct(final Product product, final String id);

    void deleteProduct(final String id);
}
