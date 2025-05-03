package com.fou.example.nosqlcrud.service;

import com.fou.example.nosqlcrud.domain.Product;
import com.fou.example.nosqlcrud.exception.NotFoundException;
import com.fou.example.nosqlcrud.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private  final ProductRepo productRepo;

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts(final String sort) {
        Sort sort1 = Sort.by(sort).descending();
        PageRequest pageRequest = PageRequest.of(0, 5, sort1);
        return productRepo.findAll(pageRequest).getContent();
    }

    @Override
    public Product getProductById(String id) {
        return productRepo.findById(id).orElseThrow(()->new NotFoundException("Product not found with id: " + id));

    }

    @Override
    public Product updateProduct(Product product, String id) {
        Product existingProduct = productRepo.findById(id).orElseThrow(RuntimeException::new);
        existingProduct.setQte(product.getQte());
        existingProduct.setLabel(product.getLabel());
        productRepo.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void deleteProduct(String id) {
        productRepo.findById(id).orElseThrow(RuntimeException::new);
        productRepo.deleteById(id);

    }
}
