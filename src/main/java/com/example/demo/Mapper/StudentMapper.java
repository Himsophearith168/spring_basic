package com.example.demo.Mapper;

import com.example.demo.DTO.StudentRequest;
import com.example.demo.DTO.StudentResponse;
import com.example.demo.Model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toEntity(StudentRequest dto) {
        return Student.builder()
                .name(dto.name())
                .age(dto.age())
                .email(dto.email())
                .address(dto.address())
                .score(dto.score())
                .build();
    }

    public StudentResponse toResponse(Student entity) {
        return new StudentResponse(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getScore()
        );
    }
}
