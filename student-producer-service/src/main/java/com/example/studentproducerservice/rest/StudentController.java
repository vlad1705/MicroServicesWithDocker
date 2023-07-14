package com.example.studentproducerservice.rest;

import com.example.studentproducerservice.DTO.StudentDTO;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private KafkaTemplate<String,StudentDTO> kafkaTemplate;

    @PostMapping
    public void publishStudentMessage(@RequestBody StudentDTO student){
        kafkaTemplate.send("studentTopic", student);
    }
}
