package com.gritacademyAPI.Studenter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Long> {
}
