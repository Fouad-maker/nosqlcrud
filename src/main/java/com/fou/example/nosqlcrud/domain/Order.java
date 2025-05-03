package com.fou.example.nosqlcrud.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "orders")
@Setter
@Getter
public class Order {

    private String id;

    private List<Product> products;

    private Date orderDate;
}
