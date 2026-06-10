package com.example.demo.DTO;

public record ProductResponse(
    Long id,
    String name,
    double price,
    int quantity,
    String description
) {}
