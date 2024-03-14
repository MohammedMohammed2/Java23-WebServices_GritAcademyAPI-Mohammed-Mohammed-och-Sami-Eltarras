package com.gritacademyAPI.courses;

import com.gritacademyAPI.studenter.Students;
import com.gritacademyAPI.studenter.StudentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursesServices {

    @Autowired
    CoursesRepository coursesRepository;

  public List<CoursesDTO> getAllCourses(){

      return coursesRepository.findAll().stream().map(this::mapsToDTO).collect(Collectors.toList());
  }
    public List<CoursesDTO> getCourseById(Long id) {

        Optional<Courses> courses = coursesRepository.findStudentsById(id).map(course -> {
            course.getStudents().size();
            return course;
        });
        return courses.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

    }
    public List<CoursesDTO> getStudentsByCourseFullName(String name) {
        Optional<Courses> courses = coursesRepository.findStudentsByName(name).map(course -> {
            course.getStudents().size();
            return course;
        });
        return courses.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    public List<CoursesDTO> getStudentsByCourseName(String name) {
        Optional<Courses> courses = coursesRepository.findByNameContaining(name);
        return courses.stream()
                .map(this::mapsToDTO)
                .collect(Collectors.toList());
        }

      public List<CoursesDTO> getStudentsByCourseDescription(String description) {
        Optional<Courses> courses = coursesRepository.findByDescriptionContaining(description);
          return courses.stream()
                  .map(this::mapsToDTO)
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
    private CoursesDTO mapsToDTO (Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setDescription(courses.getDescription());

        return dto;
    }
}
