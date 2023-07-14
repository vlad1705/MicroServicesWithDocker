package com.example.petproject.repository;

import com.example.petproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s left join fetch s.notes")
    List<Student> findAll();

    @Query("SELECT CASE WHEN COUNT(s) > 0 " +
            "THEN TRUE ELSE FALSE END " +
            "FROM Student s " +
            "WHERE s.email = :email"
    )
    Boolean selectExistsEmail(String email);
}
