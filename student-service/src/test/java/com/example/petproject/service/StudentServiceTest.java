package com.example.petproject.service;

import com.example.petproject.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = StudentService.builder().studentRepository(studentRepository).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void canGetAllStudents() {
        underTest.getStudents();

        verify(studentRepository).findAll(); //перевіряє чи така дія була виконана
    }

    @Test
    void cannotGetAllStudents() {
        given(studentRepository.findAll()).willReturn(null);

        assertThatThrownBy(()-> underTest.getStudents())
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Students dont exist");
    }

    @Test
    @Disabled
    void getStudentsUsingCriteriaApi() {
    }
}