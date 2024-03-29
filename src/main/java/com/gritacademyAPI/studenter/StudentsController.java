package com.gritacademyAPI.studenter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micrometer.common.util.StringUtils;
import org.hibernate.mapping.TableOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentsController {
    @Autowired
    StudentsServices studentsServices;
    
    @GetMapping(value = "/students")
    public List<StudentsDTO> allStudents() {

        return studentsServices.getStudents();
    }

    @GetMapping(value = "/studentsCourses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<StudentsDTO>> getStudentsCourses(){
        List<StudentsDTO> allStudents = studentsServices.getStudentsCourses();

        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping(value = "/students/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<StudentsDTO>> getCoursesForStudents(
            @RequestParam(value = "id") Long id
    ){
        List<StudentsDTO> studentsDTOS = studentsServices.getCoursesForStudents(id);

        if (studentsDTOS.isEmpty()){
            throw new RuntimeException("Cant find id");
        }

        return new ResponseEntity<>(studentsDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/students/fName/{fName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getCoursesByfName (
            @PathVariable(value = "fName")String fName
    ){
        List<StudentsDTO> studentsDTOS = studentsServices.getCoursesbyfName(fName);

        if (studentsDTOS.isEmpty()){
            throw new RuntimeException("Cant find first name");
        }

        return new ResponseEntity<>(studentsDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/students/lName/{lName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getCoursesBylName (
            @PathVariable(value = "lName")String lName
    ){
        List<StudentsDTO> studentsDTOS = studentsServices.getCoursesbylName(lName);

        if (studentsDTOS.isEmpty()){
            throw new RuntimeException("Cant find last name");
        }

        return new ResponseEntity<>(studentsDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/students/town/{town}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getCoursesTown (
            @PathVariable(value = "town")String town
    ){
            List<StudentsDTO> studentsDTOS = studentsServices.getCoursesByTown(town);

        if (studentsDTOS.isEmpty()){
            throw new RuntimeException("Cant find town");
        }

            return new ResponseEntity<>(studentsDTOS,HttpStatus.OK);
    }


    @PostMapping(value = "/createStudent")
    public ResponseEntity<Students> createStudent(@RequestBody Students student){

        studentsServices.saveStudents(student);

        if (StringUtils.isBlank(student.getFName())){
            throw new RuntimeException("Missing first name");
        }
        if (StringUtils.isBlank(student.getLName())){
            throw new RuntimeException("Missing last name");
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(value = "/removeStudent/{id}")
    public ResponseEntity<List<StudentsDTO>> removeStudent(
            @PathVariable(value = "id") Long id
    ){
        studentsServices.removeStudentsById(id);


        return new ResponseEntity<>(studentsServices.getStudents(), HttpStatus.OK);
    }
}
