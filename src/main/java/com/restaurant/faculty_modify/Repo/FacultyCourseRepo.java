package com.restaurant.faculty_modify.Repo;

import com.restaurant.faculty_modify.Entity.Faculty_Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FacultyCourseRepo  extends JpaRepository<Faculty_Courses, Integer> {
    List<Faculty_Courses> findByCourseId(Integer courseId);
   // Optional<Faculty_Courses> findByCourseIdAndFacultyId(Integer courseId, Integer facultyId);

    Optional<Faculty_Courses> findByCourseIdAndFacultyId(Integer courseId, Integer facultyId);


    // Optional<Faculty_Courses> findByCourseIdAndFacultyId(@Param("courseId") Integer courseId, @Param("facultyId") Integer facultyId);
}


