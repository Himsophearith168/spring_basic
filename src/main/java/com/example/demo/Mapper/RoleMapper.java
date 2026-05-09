package com.example.demo.Mapper;

import com.example.demo.DTO.RoleRequest;
import com.example.demo.DTO.RoleResponse;
import com.example.demo.Model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role toRoleRequest(RoleRequest dto) {
        return Role.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
    public Role toRoleResponse(Role dto) {
        return Role.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
