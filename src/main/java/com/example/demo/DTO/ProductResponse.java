package com.example.demo.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private String description;
}
