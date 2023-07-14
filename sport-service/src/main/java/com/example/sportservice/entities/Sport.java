package com.example.sportservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "sport_description")
@Data
@ToString
@AllArgsConstructor
@Builder
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sport_name")
    private String sportName;

    @Column(name="student_id")
    private String studentId;

    public Sport() {

    }

}
