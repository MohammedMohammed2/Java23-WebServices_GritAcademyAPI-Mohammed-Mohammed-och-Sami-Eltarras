package com.gritacademyAPI.courses;

import com.gritacademyAPI.Studenter.StudentsDTO;
import lombok.Data;

import java.util.List;

@Data
public class CoursesDTO {
        private String name;
        private String description;
        List<StudentsDTO> students;
 }

