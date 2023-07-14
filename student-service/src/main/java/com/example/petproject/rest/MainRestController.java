package com.example.petproject.rest;

import com.example.petproject.DTO.CatFactDTO;
import com.example.petproject.DTO.CustomStudentDto;
import com.example.petproject.DTO.StudentDto;
import com.example.petproject.Mappers.StudentMapper;
import com.example.petproject.annotations.AccessRole;
import com.example.petproject.annotations.Role;
import com.example.petproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class MainRestController {
    private final StudentService studentService;
    private final RestTemplate restTemplate;

    @GetMapping
    @AccessRole(values = {Role.ADMIN})
    List<StudentDto> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/withSports/{studentId}")
    @AccessRole(values = {Role.ADMIN})
    public CustomStudentDto getStudentWithSports(@PathVariable Long studentId){
        return studentService.getWithSportsById(studentId);
    }

    @GetMapping("/test")
    @AccessRole(values = {Role.ADMIN})
    public List<StudentDto> getStudentUsingCriteriaApi(){
        return StudentMapper.INSTANCE.studentToStudentDtoList(studentService.getStudentsUsingCriteriaApi());
    }

    @GetMapping("/catsRandom")
    @AccessRole(values = {Role.ADMIN, Role.USER})
    public CatFactDTO getStudentWithSports(){
        CatFactDTO result = restTemplate.getForObject("https://catfact.ninja/fact", CatFactDTO.class);
        return result;
    }
}
