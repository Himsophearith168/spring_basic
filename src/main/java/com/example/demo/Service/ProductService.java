package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getall(){
        return productRepository.findAll();
    }

    public Optional<Product> findbyid(Long id){
        return productRepository.findById(id);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id,Product product){
        Product check = productRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Product not found"));
        product.setName(check.getName());
        product.setPrice(check.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        Product check = productRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Product not found"));
        productRepository.delete(check);
    }
}
