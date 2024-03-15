package com.gritacademyAPI.courses;

import com.gritacademyAPI.studenter.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Long> {

    List<Courses> findByNameContaining(String name);
    List<Courses> findByDescriptionContaining(String description);
    List<Courses> findStudentsByName(String name);

}
