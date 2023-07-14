package com.example.sportservice.repository;

import com.example.sportservice.entities.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportRepository extends JpaRepository<Sport, Long> {
    List<Sport> findAllByStudentId(String studentId);
}
