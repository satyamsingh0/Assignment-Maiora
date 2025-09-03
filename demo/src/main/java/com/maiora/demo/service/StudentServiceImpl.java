package com.maiora.demo.service;

import com.maiora.demo.entity.Student;
import com.maiora.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String saveStudent(Student student) {
        int age = calculateAge(student.getBirthYear(),student.getBirthMonth(),student.getBirthDay());
        student.setAge(age);
        studentRepository.save(student);
        return "Data saved successfully";
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsBetween18And25() {
        return studentRepository.findStudentsByAgeRange(18, 25);
    }

    private int calculateAge(int year, int month, int day) {
        LocalDate dob = LocalDate.of(year,month,day);
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
