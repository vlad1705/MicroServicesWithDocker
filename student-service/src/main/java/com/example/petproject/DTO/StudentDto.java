package com.example.petproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private List<NoteDto> notes;
}
