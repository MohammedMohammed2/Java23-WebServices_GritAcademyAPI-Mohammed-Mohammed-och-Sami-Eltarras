package com.gritacademyAPI.studenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/students")
public class StudentsController {
    @Autowired
    StudentsServices studentsServices;

    @Autowired
    StudentsRepository studentsRepository;

    @GetMapping
    public List<Students> getStudents(){
        return studentsServices.getStudents();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Students>getStudentById(
            @PathVariable(value = "id")Long id
    ){
        return studentsServices.getStudentById(id);
    }


    @GetMapping(value = "name/{fName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Students>> getCoursesByfName (
            @PathVariable(value = "fName")String fName
    ){
        return studentsServices.getCoursesByfName(fName);
    }

}
