package com.example.demo.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResonse {
    private String username;
    private String password;
    private String email;
    private String address;
}
