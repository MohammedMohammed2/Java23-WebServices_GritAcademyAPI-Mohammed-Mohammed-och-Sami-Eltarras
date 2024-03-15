package com.gritacademyAPI.studenter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {


    List<Students> findCoursesByfName(String fName);

    List<Students> findCoursesBylName(String lName);
    List <Students> findCoursesByTown(String town);
}
