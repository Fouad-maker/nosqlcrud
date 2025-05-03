package com.fou.example.nosqlcrud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "products")
@Setter
@Getter
@AllArgsConstructor
public class Product {
    @Id
    private String id;

    private String label;

    @Indexed(unique = true)
    private UUID Pid;

    private int qte;

}
