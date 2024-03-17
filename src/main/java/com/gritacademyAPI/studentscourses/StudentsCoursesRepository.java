package com.gritacademyAPI.studentscourses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsCoursesRepository extends JpaRepository<StudentsCourses, Long> {


}
