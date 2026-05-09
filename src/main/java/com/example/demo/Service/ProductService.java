package com.example.demo.Service;

import com.example.demo.DTO.ProductResponse;
import com.example.demo.Mapper.ProductMapper;
import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public List<ProductResponse> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return productMapper.toProductResponse(product);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product check = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        check.setName(product.getName());
        check.setPrice(product.getPrice());
        check.setQuantity(product.getQuantity());
        check.setDescription(product.getDescription());

        return productRepository.save(check);
    }

    public void deleteProduct(Long id) {
        Product check = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        productRepository.delete(check);
    }
}
