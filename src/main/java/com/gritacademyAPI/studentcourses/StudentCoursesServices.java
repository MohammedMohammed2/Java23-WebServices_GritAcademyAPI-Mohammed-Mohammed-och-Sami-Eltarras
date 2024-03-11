package com.gritacademyAPI.studentcourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCoursesServices {

    @Autowired
    StudentCoursesRepository studentCoursesRepository;


}
