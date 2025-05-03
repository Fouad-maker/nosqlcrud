package com.fou.example.nosqlcrud.repository;

import com.fou.example.nosqlcrud.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String> {
}
