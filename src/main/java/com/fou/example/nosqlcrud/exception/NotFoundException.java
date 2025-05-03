package com.fou.example.nosqlcrud.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(final String id) {
        super(" not found with ID: " + id);
    }

}
