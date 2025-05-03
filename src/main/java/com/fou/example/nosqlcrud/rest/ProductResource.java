package com.fou.example.nosqlcrud.rest;

import com.fou.example.nosqlcrud.domain.Product;
import com.fou.example.nosqlcrud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProducts("label");
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String productId){
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id,
                                                   @RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted Successfully.",HttpStatus.OK);
    }


}
