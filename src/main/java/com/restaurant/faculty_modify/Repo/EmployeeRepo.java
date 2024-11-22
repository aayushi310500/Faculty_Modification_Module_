package com.restaurant.faculty_modify.Repo;

import com.restaurant.faculty_modify.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
     Optional<Employee> findByEmail(String email);
//    deleteById(String id);

}
