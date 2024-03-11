package com.gritacademyAPI.studentscourses;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "students_courses")
@Table(name = "students_courses")
@Data
public class StudentsCourses {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
