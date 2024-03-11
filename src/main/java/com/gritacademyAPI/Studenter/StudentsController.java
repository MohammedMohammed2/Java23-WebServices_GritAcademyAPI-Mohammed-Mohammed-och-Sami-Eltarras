package com.gritacademyAPI.Studenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/students")
public class StudentsController {
    @Autowired
    StudentsServices studentsServices;


    @GetMapping
    List<Students> getstudents(){
        return studentsServices.getStudents();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    List<Students> getStudentById(
            @PathVariable(value = "id")Long id){
        return studentsServices.getStudents();
    }
}
