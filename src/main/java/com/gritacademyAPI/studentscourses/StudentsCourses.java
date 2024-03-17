package com.gritacademyAPI.studentscourses;

import com.gritacademyAPI.courses.Courses;
import com.gritacademyAPI.studenter.Students;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "students_courses")
@Table(name = "students_courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentsCourses {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "students_id", referencedColumnName = "id")
    private Students studentsId;

    @ManyToOne
    @JoinColumn(name = "courses_id", referencedColumnName = "id")
    private Courses coursesId;

}
