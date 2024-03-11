package com.gritacademyAPI.studentcourses;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "student_courses")
@Table(name = "students_courses")
@Data
public class StudentCourses {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
