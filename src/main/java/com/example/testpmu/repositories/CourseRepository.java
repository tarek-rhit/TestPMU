package com.example.testpmu.repositories;

import com.example.testpmu.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository< Course,Long> {
}
