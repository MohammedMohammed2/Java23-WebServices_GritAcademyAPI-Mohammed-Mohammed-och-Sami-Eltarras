package com.gritacademyAPI.studentscourses;

import com.gritacademyAPI.studenter.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentscourses")
public class StudentsCoursesController {

    @Autowired
    StudentsCoursesServices studentsCoursesServices;

}