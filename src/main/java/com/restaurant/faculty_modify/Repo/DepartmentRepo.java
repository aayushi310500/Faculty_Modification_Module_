package com.restaurant.faculty_modify.Repo;

import com.restaurant.faculty_modify.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    boolean existsById(Long id);
}