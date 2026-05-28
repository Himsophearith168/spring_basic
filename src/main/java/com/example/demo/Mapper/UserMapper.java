package com.example.demo.Mapper;

import com.example.demo.DTO.UserRequest;
import com.example.demo.DTO.UserResonse;
import com.example.demo.Model.user;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public user touserRequest (UserRequest dto){
        return user.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getPassword())
                .address(dto.getAddress())
                .build();
    }
    public UserResonse touserResponse (user dto){
        return UserResonse.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .build();
    }

}
