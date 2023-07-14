package com.example.petproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "notes")
@Data
@ToString
@AllArgsConstructor
@Builder
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private String grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Note() {

    }
}
