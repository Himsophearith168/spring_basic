package com.example.demo.DTO;

import jakarta.validation.constraints.*;

public record StudentRequest(
    @NotBlank(message = "Student name is required")
    @Size(min = 2, max = 100, message = "Student name must be between 2 and 100 characters")
    String name,

    @Min(value = 5, message = "Age must be at least 5")
    @Max(value = 100, message = "Age must be at most 100")
    Integer age,

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    String email,

    String address,

    @Min(value = 0, message = "Score cannot be negative")
    @Max(value = 100, message = "Score cannot exceed 100")
    Double score
) {}
