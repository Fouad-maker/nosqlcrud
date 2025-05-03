package com.fou.example.nosqlcrud.repository;

import com.fou.example.nosqlcrud.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<Order, String> {
}
