package com.example.demo.Mapper;

import com.example.demo.DTO.StudentRequest;
import com.example.demo.DTO.StudentResponse;
import com.example.demo.Model.student;
import org.springframework.stereotype.Component;


@Component
public class StudentMapper {
    public student toStudentRequest(StudentRequest dto){
        return student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .build();
    }
    public StudentResponse toStudentResponse(student dto){
        return StudentResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .build();
    }
}
