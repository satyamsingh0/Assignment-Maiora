package com.maiora.demo.service;

import com.maiora.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    String saveStudent(Student student);
    List<Student> getAllStudents();
    List<Student> getStudentsBetween18And25();
}
