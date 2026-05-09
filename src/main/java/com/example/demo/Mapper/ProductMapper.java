package com.example.demo.Mapper;


import com.example.demo.DTO.ProductRequest;
import com.example.demo.DTO.ProductResponse;
import com.example.demo.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductRequest dto) {
         return Product.builder()
                 .name(dto.getName())
                 .price(dto.getPrice())
                 .quantity(dto.getQuantity())
                 .description(dto.getDescription())
                 .build();
    }
    public ProductResponse toProductResponse(Product dto) {
        return ProductResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .description(dto.getDescription())
                .build();
    }
}
