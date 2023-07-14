package com.example.petproject.repository;

import com.example.petproject.entity.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    //робить проксьований репозиторій за рахунок анотації @datajpatest який буде використовувати локально наконфігурену бд
    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }


    @Test
    void ifTheStudentByGivenEmailExists() {
        //given
        Student student = Student.builder().id(2L).email("vp@gmail.com").firstName("Vlad").firstName("Pasemko").build();
        underTest.save(student);

        boolean existsEmail = underTest.selectExistsEmail("vp@gmail.com");

        assertThat(existsEmail).isTrue();
    }
    @Test
    void ifTheStudentByGivenEmailDoesNotExists() {
        //given
        Student student = Student.builder().id(2L).email("p@gmail.com").firstName("Vlad").firstName("Pasemko").build();
        underTest.save(student);

        boolean existsEmail = underTest.selectExistsEmail("vp@gmail.com");

        assertThat(existsEmail).isFalse();
    }
}