package com.example.petproject.Mappers;

import com.example.petproject.DTO.NoteDto;
import com.example.petproject.DTO.StudentDto;
import com.example.petproject.entity.Note;
import com.example.petproject.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper( StudentMapper.class );

    NoteDto noteToNoteDto(Note note);

    List<NoteDto> noteToNoteDtoList(List<Note> notes);

    StudentDto studentToStudentDto(Student student);

    List<StudentDto> studentToStudentDtoList(List<Student> students);

    Student studentDtoToStudent(StudentDto studentDto);

    List<Student> studentDtoToStudentList(List<StudentDto> studentsDto);
}
