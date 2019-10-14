package com.example.shopapp.services;

import com.example.shopapp.entities.Product;
import com.example.shopapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getProducts();
    }

    public Product getById(Long id) {
        return productRepository.getProducts().get(id.intValue() - 1);
    }
}
