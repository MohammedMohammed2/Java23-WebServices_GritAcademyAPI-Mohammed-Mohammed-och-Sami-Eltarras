package com.gritacademyAPI.studenter;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    public List<Students> allStudents() {

        return studentsServices.allStudents();
    }

    @GetMapping(value = "/studentsassociations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<StudentsDTO>> students(){
        List<StudentsDTO> allStudents = studentsServices.getStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<StudentsDTO>> getCoursesForStudents(
            @PathVariable(value = "id") Long id
    ){
        List<StudentsDTO> studentsDTOS = studentsServices.getCoursesForStudents(id);
        return new ResponseEntity<>(studentsDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "search/{fName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Students>> getCoursesByfName (
            @PathVariable(value = "fName")String fName
    ){
        return studentsServices.getCoursesByfName(fName);
    }

    @GetMapping(value = "search/lastname/{lName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Students>> getCoursesBylName (
            @PathVariable(value = "lName")String lName
    ){
        return studentsServices.getCoursesBylName(lName);
    }

    @GetMapping(value = "search/town/{town}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Students>> getCoursesTown (
            @PathVariable(value = "town")String Town
    ){
        return studentsServices.getCoursesByTown(Town);
    }

}
