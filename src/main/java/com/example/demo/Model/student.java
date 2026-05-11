package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.format.DateTimeFormatter;

@Entity
@Table (name = "student")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;
    private Long age;
    private String address;
    private String email;

}
