package com.gritacademyAPI.courses;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "kurser")
@Table(name = "kurser")
@Getter
@Setter
public class Courses {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private  String description;

}
