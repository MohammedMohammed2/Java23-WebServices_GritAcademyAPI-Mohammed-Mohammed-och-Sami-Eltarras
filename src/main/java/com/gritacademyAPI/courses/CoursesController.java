package com.gritacademyAPI.courses;

import com.gritacademyAPI.studenter.Students;
import com.gritacademyAPI.studenter.StudentsDTO;
import com.gritacademyAPI.studenter.StudentsServices;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if (coursesDTOS.isEmpty()){
            throw new RuntimeException("Cant find id");
        }

        return new ResponseEntity<>(coursesDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/courseName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getStudentsByCourseFullName (
            @PathVariable(value = "name") String name
    ){
        List<CoursesDTO> coursesDTOS = coursesServices.getStudentsByCourseFullName(name);

        if (coursesDTOS.isEmpty()){
            throw new RuntimeException("Cant find name");
        }

        return new ResponseEntity<>(coursesDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getStudentsByCourseName (
            @PathVariable(value = "name")String name
    ){
        List<CoursesDTO> coursesDTOS = coursesServices.getStudentsByCourseName(name);

        if (coursesDTOS.isEmpty()){
            throw new RuntimeException("Cant find course");
        }

        return new ResponseEntity<>(coursesDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/courses/desc/{description}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getStudentsByCourseDescription (
            @PathVariable(value = "description") String description
    ){
        List<CoursesDTO> coursesDTOS = coursesServices.getStudentsByCourseDescription(description);

        if (coursesDTOS.isEmpty()){
            throw new RuntimeException("Cant find description");
        }

        return new ResponseEntity<>(coursesDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/addCourse")
    public ResponseEntity<Courses> addCourse(@RequestBody Courses course){

        coursesServices.addCourse(course);

        if (StringUtils.isBlank(course.getName())){
            throw new RuntimeException("Cant find course name");
        }

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping(value = "/removeCourse/{id}")
    public ResponseEntity<Courses> removeCourse (
            @PathVariable("id") Long id
    ){
        coursesServices.removeCourse(id);

        return ResponseEntity.ok().build();

    }
}
