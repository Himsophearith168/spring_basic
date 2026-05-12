package com.example.demo.Service;

import com.example.demo.DTO.StudentRequest;
import com.example.demo.DTO.StudentResponse;
import com.example.demo.Mapper.StudentMapper;
import com.example.demo.Model.StudentModel;
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

//    Get All Student
    public List<StudentResponse> findAll(){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponse)
                .collect(Collectors.toList());
    }

//    Get By ID
    public StudentResponse findById(Long id){
        StudentModel student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return studentMapper.toStudentResponse(student);
    }

//    Create
    public StudentResponse createStudent(StudentModel student){
        StudentModel Student = studentRepository.save(student);
        return studentMapper.toStudentResponse(Student);
    }

//    Update Student
    public StudentResponse updateStudent(Long id, StudentModel student){
        StudentModel Student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        Student.setName(student.getName());
        Student.setAge(student.getAge());
        Student.setEmail(student.getEmail());
        Student.setAddress(student.getAddress());
        studentRepository.save(Student);
        return studentMapper.toStudentResponse(Student);
    }

//    Delete Student
    public void deleteStudent(Long id){
        var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(student);
    }

}
