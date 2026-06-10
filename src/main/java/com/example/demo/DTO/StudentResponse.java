package com.example.demo.DTO;

public record StudentResponse(
    Long id,
    String name,
    Integer age,
    String email,
    String address,
    Double score
) {}
