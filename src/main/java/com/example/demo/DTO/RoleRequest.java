package com.example.demo.DTO;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleRequest {
    private String name;
    private String description;

    public Long getId() {
        return null;
    }
}
