package com.gritacademyAPI.courses;

import com.gritacademyAPI.studenter.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoursesRepository extends JpaRepository<Courses,Long> {

    List <Courses> findStudentsByName(String name);

}
