package com.maiora.demo.controller;

import com.maiora.demo.entity.Student;
import com.maiora.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping()
    public String saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/age-range")
    public List<Student> getStudentsBetween18And25() {
        return studentService.getStudentsBetween18And25();
    }
}
