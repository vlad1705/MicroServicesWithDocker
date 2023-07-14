package com.example.petproject.service;

import com.example.petproject.DTO.CustomStudentDto;
import com.example.petproject.DTO.StudentDto;
import com.example.petproject.Mappers.StudentMapper;
import com.example.petproject.client.SportsClient;
import com.example.petproject.entity.Student;
import com.example.petproject.repository.FilterQueryRepository;
import com.example.petproject.repository.StudentRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Builder
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final FilterQueryRepository filterQueryRepository;
    private final SportsClient sportsClient;

    @Transactional(readOnly = true)
    public List<StudentDto> getStudents(){
        var students = studentRepository.findAll();


        if(students==null){
            throw new RuntimeException("Students dont exist");
        }

        return StudentMapper.INSTANCE.studentToStudentDtoList(students);
    }

    public CustomStudentDto getWithSportsById(Long studentId){
        var student = studentRepository.findById(studentId).orElseThrow();

        var sports = sportsClient.getSportsByStudentId(studentId);

        return new CustomStudentDto(student.getFirstName(),student.getLastName(),sports);

    }

    @Transactional(readOnly = true)
    public List<Student> getStudentsUsingCriteriaApi(){
         return filterQueryRepository.findBooksByAuthorEmail("vp@gmail.com");
    }

    public void saveStudent(StudentDto student){
        studentRepository.save(StudentMapper.INSTANCE.studentDtoToStudent(student));
    }

}
