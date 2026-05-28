package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userDB")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String address;

}
