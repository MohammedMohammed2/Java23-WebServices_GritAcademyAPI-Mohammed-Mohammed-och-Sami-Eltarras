package com.gritacademyAPI.studentscourses;

import com.gritacademyAPI.courses.Courses;
import com.gritacademyAPI.studenter.Students;
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

    @ManyToMany
    @JoinColumn(name = "students_id", referencedColumnName = "id")
    private Students students;

    @ManyToMany
    @JoinColumn(name = "courses_id", referencedColumnName = "id")
    private Courses coursesId;

}
