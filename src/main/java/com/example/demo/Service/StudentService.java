package com.example.demo.Service;

import com.example.demo.DTO.StudentRequest;
import com.example.demo.DTO.StudentResponse;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Mapper.StudentMapper;
import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentResponse> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public StudentResponse findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return studentMapper.toResponse(student);
    }

    public StudentResponse createStudent(StudentRequest request) {
        Student student = studentMapper.toEntity(request);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponse(savedStudent);
    }

    public StudentResponse updateStudent(Long id, StudentRequest request) {
        Student studentExist = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        studentExist.setName(request.name());
        studentExist.setAge(request.age());
        studentExist.setEmail(request.email());
        studentExist.setAddress(request.address());
        studentExist.setScore(request.score());

        Student updatedStudent = studentRepository.save(studentExist);
        return studentMapper.toResponse(updatedStudent);
    }

    public void deleteStudent(Long id) {
        Student studentExist = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepository.delete(studentExist);
    }
}
