package com.gritacademyAPI.courses;

import com.gritacademyAPI.studenter.Students;
import com.gritacademyAPI.studenter.StudentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<CoursesDTO> getStudentsByCourseName(String name) {
        Optional<Courses> courses = coursesRepository.findByNameContaining(name).map(course -> {
            course.getStudents().size();
            return course;
        });
        return courses.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
      public List<CoursesDTO> getStudentsByCourseDescription(String description) {
        Optional<Courses> courses = coursesRepository.findByDescriptionContaining(description).map(course -> {
            course.getStudents().size();
            return course;
        });
        return courses.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private StudentsDTO mapToDTO(Students students){
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFName(students.getFName());
        dto.setLName(students.getLName());
        dto.setTown(students.getTown());
        return dto;

    }

    private CoursesDTO mapToDTO (Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setDescription(courses.getDescription());
        dto.setStudents(courses.getStudents()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));
        return dto;
    }

}
