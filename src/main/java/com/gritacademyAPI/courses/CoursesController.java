package com.gritacademyAPI.courses;

import com.gritacademyAPI.studenter.Students;
import com.gritacademyAPI.studenter.StudentsDTO;
import com.gritacademyAPI.studenter.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoursesController {

    @Autowired
    CoursesServices coursesServices;

    @GetMapping(value = "/courses")
    public List<CoursesDTO> courses(){
        return coursesServices.getAllCourses();
    }

    @GetMapping(value = "/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCourseById(
            @PathVariable(value = "id") Long id
    ){
        List<CoursesDTO> coursesDTOS = coursesServices.getCourseById(id);
        return new ResponseEntity<>(coursesDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/courseName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getStudentsByCourseFullName (
            @PathVariable(value = "name") String name
    ){
        List<CoursesDTO> coursesDTOS = coursesServices.getStudentsByCourseFullName(name);
        return new ResponseEntity<>(coursesDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getStudentsByCourseName (
            @PathVariable(value = "name")String name
    ){
        List<CoursesDTO> coursesDTOS = coursesServices.getStudentsByCourseName(name);
        return new ResponseEntity<>(coursesDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/desc/{description}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getStudentsByCourseDescription (
            @PathVariable(value = "description") String description
    ){
        List<CoursesDTO> coursesDTOS = coursesServices.getStudentsByCourseDescription(description);
        return new ResponseEntity<>(coursesDTOS, HttpStatus.OK);
    }
}
