package com.gritacademyAPI.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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





}
