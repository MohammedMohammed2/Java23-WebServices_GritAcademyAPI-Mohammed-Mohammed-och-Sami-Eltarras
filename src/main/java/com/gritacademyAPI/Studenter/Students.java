package com.gritacademyAPI.Studenter;

import jakarta.persistence.*;
import lombok.*;

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
}
