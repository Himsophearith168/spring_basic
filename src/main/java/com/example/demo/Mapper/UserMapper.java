package com.example.demo.Mapper;

import com.example.demo.DTO.UserRequest;
import com.example.demo.DTO.UserResponse;
import com.example.demo.Model.user;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public user toEntity(UserRequest dto) {
        return user.builder()
                .username(dto.username())
                .password(dto.password())
                .email(dto.email())
                .address(dto.address())
                .build();
    }

    public UserResponse toResponse(user entity) {
        return new UserResponse(
                entity.getUsername(),
                entity.getEmail(),
                entity.getAddress()
        );
    }
}
