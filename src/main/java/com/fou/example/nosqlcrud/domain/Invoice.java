package com.fou.example.nosqlcrud.domain;

import com.fou.example.nosqlcrud.model.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "invoices")
@Setter
@Getter
public class Invoice {
    private String orderId;
    private String invoiceDate;
    private double tax;
    private double totalAmount;
    private double discount;
    private Status Status;
    private String notes;


}
