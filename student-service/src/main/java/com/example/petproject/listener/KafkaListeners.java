package com.example.petproject.listener;

import com.example.petproject.DTO.StudentDto;
import com.example.petproject.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class KafkaListeners {
    private final ObjectMapper objectMapper;
    private StudentService studentService;

    @KafkaListener(topics = "studentTopic", groupId = "foo")
    public void listener(String message) {
        System.out.println("Received message: " + message);
        try {
            studentService.saveStudent(objectMapper.readValue(message, StudentDto.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
