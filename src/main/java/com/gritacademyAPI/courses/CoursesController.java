package com.gritacademyAPI.courses;

import com.gritacademyAPI.studenter.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CoursesController {

    @Autowired
    CoursesServices coursesServices;



    @GetMapping
    List<Courses>getcourses(){ return coursesServices.getCourses();}

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Courses> getCourseById(
            @PathVariable(value = "id") Long id
    ){
        return coursesServices.getCourseById(id);
    }
    @GetMapping(value = "search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Courses>> getStudentsByName (
            @PathVariable(value = "name")String name
    ){
        return coursesServices.getStudentsByName(name);
    }



}
