package com.example.demo.Mapper;

import com.example.demo.DTO.ProductRequest;
import com.example.demo.DTO.ProductResponse;
import com.example.demo.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequest dto) {
        return Product.builder()
                .name(dto.name())
                .price(dto.price())
                .quantity(dto.quantity())
                .description(dto.description())
                .build();
    }

    public ProductResponse toResponse(Product entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getQuantity(),
                entity.getDescription()
        );
    }
}
