package com.gritacademyAPI.studenter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {


    Optional<Students> findCoursesByfName(String fName);

    Optional<Students> findCoursesBylName(String lName);
    List <Students> findCoursesByTown(String town);
}
