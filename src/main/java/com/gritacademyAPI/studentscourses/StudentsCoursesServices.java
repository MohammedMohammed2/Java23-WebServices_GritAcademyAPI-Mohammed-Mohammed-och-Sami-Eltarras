package com.gritacademyAPI.studentscourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsCoursesServices {

    @Autowired
    StudentsCoursesRepository studentCoursesRepository;

    public StudentsCourses addStudentCourse (StudentsCourses studentCourse){
        return studentCoursesRepository.save(studentCourse);
    }

    public void removeStudentCourse(Long id){
        studentCoursesRepository.deleteById(id);
    }
}
