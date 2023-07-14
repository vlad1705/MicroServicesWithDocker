package com.example.petproject.client;

import com.example.petproject.DTO.SportDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "sport")
public interface SportsClient {
    @GetMapping("/sport")
    @CircuitBreaker(name = "sport-service", fallbackMethod = "defaultSports")
    List<SportDto> getSportsByStudentId(@RequestParam Long studentId);

    default List<SportDto> defaultSports(Long studentId, Throwable throwable){
        return List.of(new SportDto(studentId, "Default Sport"));
    }
}
