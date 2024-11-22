package com.restaurant.faculty_modify.Service;

import com.restaurant.faculty_modify.DTO.LoginRequest;
import com.restaurant.faculty_modify.Entity.Employee;
import com.restaurant.faculty_modify.Exceptions.EmployeeNotFoundException;
import com.restaurant.faculty_modify.Helper.JWTHelper;
import com.restaurant.faculty_modify.Repo.DepartmentRepo;
import com.restaurant.faculty_modify.Repo.EmployeeRepo;
import com.restaurant.faculty_modify.Helper.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    // Get employee by email
    public Employee getEmployee(String email) {
        return employeeRepo.findByEmail(email)
                .orElseThrow((  ) -> new EmployeeNotFoundException(
                        format("No employee found with the provided ID:: %s", email)
                ));
    }

    // Login method to validate employee credentials and department existence
    public String login(LoginRequest request) {
        Employee employee = getEmployee(request.email());

        // Validate password
        if (!encryptionService.validates(request.password(), employee.getPassword())) {
            return "Wrong Password or Email";
        }

        // Check if the employee's department exists
        boolean departmentExists = departmentRepo.existsById((long) employee.getDepartment());
        if (!departmentExists) {
            return "Login failed: Department not found.";
        }

        return jwtHelper.generateToken(request.email());
    }

    public String create(Employee employee) {
        employeeRepo.save(employee);
        return "Employee created!";
    }
}
