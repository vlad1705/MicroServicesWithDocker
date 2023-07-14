package com.example.petproject.DTO;

import java.util.List;

public record CustomStudentDto (String firstName, String lastName, List<SportDto> sports){
}
