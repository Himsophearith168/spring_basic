package com.example.demo.Controller;

import com.example.demo.DTO.StudentRequest;
import com.example.demo.DTO.StudentResponse;
import com.example.demo.Model.StudentModel;
import com.example.demo.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    ResponseEntity<Map> getAllStudent(){
        var student =  studentService.findAll();
        Map res = new HashMap();
        res.put("Message","Success");
        res.put("List",student.size());
        return ResponseEntity.ok(res);
    }
    @GetMapping("/{id}")
    ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id){
        var student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }
    @PostMapping
    ResponseEntity<StudentResponse> saveStudent(@RequestBody StudentModel student){
        var Student = studentService.createStudent(student);
        return ResponseEntity.status(201).body(Student);
    }

    @PutMapping("/{id}")
    ResponseEntity<StudentResponse> updateStudent(@PathVariable Long id, @RequestBody StudentModel student){
        var Student = studentService.updateStudent(id, student);
        return ResponseEntity.ok(Student);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<StudentResponse> deleteStudent(@PathVariable Long id){
        var student = studentService.findById(id);
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
