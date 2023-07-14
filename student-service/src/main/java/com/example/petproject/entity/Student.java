
package com.example.petproject.entity;

import lombok.*;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "student")
@Data
@ToString
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Note> notes = new ArrayList<>();

    public void addNotes(Note note){
        notes.add(note);
        note.setStudent(this);
    }

    public Student() {

    }
}
