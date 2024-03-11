package com.gritacademyAPI.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoursesRepository extends JpaRepository<Courses,Long> {
    static List<Courses>findByCoursesId(Long id){return findByCoursesId(id);}
}
