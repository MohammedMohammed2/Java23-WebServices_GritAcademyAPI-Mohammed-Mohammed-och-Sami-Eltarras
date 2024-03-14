package com.gritacademyAPI.courses;

import com.gritacademyAPI.studenter.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Long> {

    Optional<Courses> findByNameContaining(String name);
    Optional<Courses> findByDescriptionContaining(String description);

}
