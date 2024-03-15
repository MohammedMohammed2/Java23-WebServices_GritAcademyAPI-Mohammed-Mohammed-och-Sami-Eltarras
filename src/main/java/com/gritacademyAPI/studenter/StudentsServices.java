package com.gritacademyAPI.studenter;

import com.gritacademyAPI.courses.Courses;
import com.gritacademyAPI.courses.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsServices {
    @Autowired
    StudentsRepository studentsRepository;

    public List<StudentsDTO> getStudents() {
        List<StudentsDTO> studentsDTO = new ArrayList<>();
        studentsRepository.findAll().forEach(students -> studentsDTO.add(this.mapsToDTO(students)));
        return studentsDTO;
    }

    public List<StudentsDTO> getStudentsCourses(){
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

    public List<StudentsDTO> getCoursesbyfName(String fname) {

        return studentsRepository.findCoursesByfName(fname)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentsDTO> getCoursesbylName(String lname) {
        return studentsRepository.findCoursesBylName(lname)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentsDTO> getCoursesByTown(String town) {
        List<Students> students = studentsRepository.findCoursesByTown(town);
        return students.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Students saveStudent(Students students){
        return studentsRepository.save(students);
    }

    public void removeStudentById(Long id){
        studentsRepository.deleteById(id);
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
    private StudentsDTO mapsToDTO (Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFName(students.getFName());
        dto.setLName(students.getLName());
        dto.setTown(students.getTown());
        return dto;
    }
}

