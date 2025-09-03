package com.maiora.demo.repository;

import com.maiora.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("SELECT s FROM Student s WHERE s.age BETWEEN :minAge AND :maxAge")
    List<Student> findStudentsByAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);
}
