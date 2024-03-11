package com.gritacademyAPI.studenter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gritacademyAPI.courses.Courses;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "students")
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fName")
    private String fName;

    @Column(name = "lName")
    private String lName;

    @Column(name = "town")
    private String town;



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "students_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id")
    )
    private Set<Courses> courses = new HashSet<>();

}
