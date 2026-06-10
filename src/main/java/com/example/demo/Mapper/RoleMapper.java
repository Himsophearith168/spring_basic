package com.example.demo.Mapper;

import com.example.demo.DTO.RoleRequest;
import com.example.demo.DTO.RoleResponse;
import com.example.demo.Model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role toEntity(RoleRequest dto) {
        return Role.builder()
                .name(dto.name())
                .description(dto.description())
                .build();
    }

    public RoleResponse toResponse(Role entity) {
        return new RoleResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }
}
