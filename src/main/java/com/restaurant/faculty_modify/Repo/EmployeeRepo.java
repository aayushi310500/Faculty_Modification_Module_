package com.restaurant.faculty_modify.Repo;

import com.restaurant.faculty_modify.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
     Optional<Employee> findByEmail(String email);

//     @Query("SELECT c.course_id FROM Courses  c WHERE c.courseFaculty = :facultyName")
//     Integer findCourseIdByFacultyName(@Param("facultyName") String facultyName);
//
//     @Transactional
//     @Modifying
//     @Query("DELETE FROM Faculty_Courses fc WHERE fc.facultyId = :facultyId")
//     void deleteByFacultyId(@Param("facultyId") Integer facultyId);

//    deleteById(String id);

}
