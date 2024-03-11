package com.gritacademyAPI.studenter;

import com.gritacademyAPI.courses.Courses;
import com.gritacademyAPI.courses.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsServices {
    @Autowired
    StudentsRepository studentsRepository;

    List<Students> allStudents(){return studentsRepository.findAll();}


    public List<StudentsDTO> getStudents() {
        List<StudentsDTO> studentsDTO = new ArrayList<>();
        studentsRepository.findAll().forEach(students -> studentsDTO.add(this.mapToDTO(students)));
        return studentsDTO;
    }

    public List<StudentsDTO> getCoursesForStudents(Long id) {
        Optional<Students> students = studentsRepository.findById(id).map(student -> {
            student.getCourses().size();
            return student;
        });
        return students.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    public ResponseEntity<List<Students>> getCoursesByfName(String fName) {
        List<Students> students = studentsRepository.findCoursesByfName(fName);
        if (students.isEmpty()){
            throw new RuntimeException("Student not found");
        }
        return ResponseEntity.ok(studentsRepository.findCoursesByfName(fName));

    }

    public ResponseEntity<List<Students>> getCoursesBylName(String lName) {
        List<Students> students = studentsRepository.findCoursesBylName(lName);
        if (students.isEmpty()){
            throw new RuntimeException("Student not found");
        }
        return ResponseEntity.ok(studentsRepository.findCoursesBylName(lName));

    }
    public ResponseEntity<List<Students>> getCoursesByTown(String town) {
        List<Students> students = studentsRepository.findCoursesByTown(town);
        if (students.isEmpty()){
            throw new RuntimeException("Student not found");
        }
        return ResponseEntity.ok(studentsRepository.findCoursesByTown(town));
    }

    private CoursesDTO mapToDTO(Courses courses){
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setDescription(courses.getDescription());

        return dto;

    }
    private StudentsDTO mapToDTO (Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFName(students.getFName());
        dto.setLName(students.getLName());
        dto.setTown(students.getTown());
        dto.setCourses(students.getCourses()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));
        return dto;
    }

}

