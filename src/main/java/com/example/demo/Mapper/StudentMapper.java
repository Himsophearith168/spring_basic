package com.example.demo.Mapper;

import com.example.demo.DTO.StudentRequest;
import com.example.demo.DTO.StudentResponse;
import com.example.demo.Model.StudentModel;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentModel toStudentRequest(StudentRequest dto){
        return StudentModel.builder()
                .id(dto.getId())
                .name(dto.getName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .score(dto.getScore())
                .build();
    }
    public StudentResponse toStudentResponse(StudentModel dto){
        return StudentResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .score(dto.getScore())
                .build();
    }
}
