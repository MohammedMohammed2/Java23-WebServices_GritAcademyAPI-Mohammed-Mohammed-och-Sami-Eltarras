package com.gritacademyAPI.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoursesServices {

    @Autowired
    CoursesRepository coursesRepository;

    List<Courses>getCourses(){return coursesRepository.findAll();}
}
