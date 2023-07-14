package com.example.sportservice.controller;

import com.example.sportservice.entities.Sport;
import com.example.sportservice.repository.SportRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sport")
public class SportController {
    private final SportRepository sportRepository;


    @GetMapping
    @SneakyThrows
    public List<Sport> getSportsByStudentId(@RequestParam String studentId){
        Thread.sleep(2000);
        return sportRepository.findAllByStudentId(studentId);
    }

    @PostMapping
    public Sport createSport(@RequestBody Sport sport){
        return sportRepository.save(sport);
    }
}
