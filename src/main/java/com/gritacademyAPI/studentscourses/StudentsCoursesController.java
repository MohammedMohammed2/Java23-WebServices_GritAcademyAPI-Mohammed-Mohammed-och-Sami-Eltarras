package com.gritacademyAPI.studentscourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsCoursesController {
    @Autowired
    StudentsCoursesServices studentsCoursesServices;
    @Autowired
    StudentsCoursesRepository studentsCoursesRepository;

    @PostMapping(value = "/addStudentCourse", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentsCourses> createStudentCourse (@RequestBody StudentsCourses studentCourse){

        studentsCoursesServices.addStudentCourse(studentCourse);

        return new ResponseEntity<>(studentCourse, HttpStatus.OK);
    }

    @PostMapping(value = "/removeStudentCourse/{id}")
    public ResponseEntity <List<StudentsCoursesDTO>> removeStudentCourse(
            @PathVariable(name = "id") Long id
    ){
        if (id != null ) {
            studentsCoursesServices.removeStudentCourse(id);

            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}