package com.restaurant.faculty_modify.Repo;

import com.restaurant.faculty_modify.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoursesRepo  extends JpaRepository<Courses, Integer> {
    Optional<Courses> findByCourseName(String courseName);
}


