package com.gritacademyAPI.courses;

import com.gritacademyAPI.studenter.StudentsDTO;
import lombok.Data;

import java.util.List;

@Data
public class CoursesDTO {
        private Long id;
        private String name;
        private String description;
        List<StudentsDTO> students;
 }

