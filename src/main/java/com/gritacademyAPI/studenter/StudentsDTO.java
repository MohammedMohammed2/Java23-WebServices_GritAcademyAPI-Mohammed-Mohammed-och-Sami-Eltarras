package com.gritacademyAPI.studenter;


import com.gritacademyAPI.courses.Courses;
import com.gritacademyAPI.courses.CoursesDTO;
import lombok.Data;

import java.util.List;

@Data
public class StudentsDTO {

    private Long id;
    private String fName;
    private String lName;
    private String town;
    List<CoursesDTO> courses;
}
