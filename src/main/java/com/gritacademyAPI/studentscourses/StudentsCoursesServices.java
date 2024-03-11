package com.gritacademyAPI.studentscourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsCoursesServices {

    @Autowired
    StudentsCoursesRepository studentCoursesRepository;


    List<StudentsCourses> getStudentsCourses(){return studentCoursesRepository.findAll();}
}