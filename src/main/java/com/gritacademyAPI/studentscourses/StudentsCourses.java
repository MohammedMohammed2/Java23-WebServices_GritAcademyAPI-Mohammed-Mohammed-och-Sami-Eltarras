package com.gritacademyAPI.studentscourses;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "studentscourses")
@Table(name = "students_courses")
@Data
public class StudentsCourses {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
