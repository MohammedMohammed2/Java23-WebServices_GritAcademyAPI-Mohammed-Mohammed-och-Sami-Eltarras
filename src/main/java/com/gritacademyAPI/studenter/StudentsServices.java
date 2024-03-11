package com.gritacademyAPI.studenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsServices{
    @Autowired
    StudentsRepository studentsRepository;

    List<Students> getStudents(){return studentsRepository.findAll();}

   public ResponseEntity<Students>getStudentById(Long id) {
        Optional<Students> students = studentsRepository.findById(id);
        if (students.isEmpty()){
            throw new RuntimeException("Student not found");
        }
        return ResponseEntity.ok(students.get());

    }





    public ResponseEntity<List<Students>> getCoursesByfName(String fName) {
        List<Students> students = studentsRepository.findCoursesByfName(fName);
        if (students.isEmpty()){
            throw new RuntimeException("Student not found");
        }
        return ResponseEntity.ok(studentsRepository.findCoursesByfName(fName));

    }

    }

