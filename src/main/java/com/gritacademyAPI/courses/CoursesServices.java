package com.gritacademyAPI.courses;

import com.gritacademyAPI.studenter.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesServices {

    @Autowired
    CoursesRepository coursesRepository;

    List<Courses> getCourses() {
        return coursesRepository.findAll();
    }

    public ResponseEntity<Courses> getCourseById(Long id) {
        Optional<Courses> courses = coursesRepository.findById(id);
        if (courses.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        return ResponseEntity.ok(courses.get());
    }
}
