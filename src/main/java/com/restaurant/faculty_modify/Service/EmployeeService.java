package com.restaurant.faculty_modify.Service;

import com.restaurant.faculty_modify.DTO.CourseUpdateRequest;
import com.restaurant.faculty_modify.DTO.LoginRequest;
import com.restaurant.faculty_modify.DTO.UpdateEmployeeRequest;
import com.restaurant.faculty_modify.DTO.getEmployeeResponse;
import com.restaurant.faculty_modify.Entity.Courses;
import com.restaurant.faculty_modify.Entity.Employee;
import com.restaurant.faculty_modify.Entity.Faculty_Courses;
import com.restaurant.faculty_modify.Exceptions.EmployeeNotFoundException;
import com.restaurant.faculty_modify.Helper.JWTHelper;
import com.restaurant.faculty_modify.Mapper.EmployeeMapper;
import com.restaurant.faculty_modify.Repo.CoursesRepo;
import com.restaurant.faculty_modify.Repo.DepartmentRepo;
import com.restaurant.faculty_modify.Repo.EmployeeRepo;
import com.restaurant.faculty_modify.Helper.EncryptionService;
import com.restaurant.faculty_modify.Repo.FacultyCourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;
    private final CoursesRepo courseRepository;
    private final FacultyCourseRepo facultyCourseRepository;
    private final EmployeeMapper employeeMapper;

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

        return jwtHelper.generateToken(request.email(),employee.getEmployee_id());
    }

    public String create(Employee employee) {
        employeeRepo.save(employee);
        return "Employee created!";
    }




    public Employee updateEmployee(String token, Employee updatedEmployee) {

        Long facultyId = jwtHelper.extractEmployeeId(token);
        if (facultyId == null) {
            throw new RuntimeException("Invalid token: Unable to extract employee ID.");
        }
        Optional<Employee> existingEmployee = employeeRepo.findById(facultyId);

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();

            // Only update fields other than id, email, and password
           // employee.setDepartment(updatedEmployee.getDepartment());
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setPhotographPath(updatedEmployee.getPhotographPath());
            employee.setTitle(updatedEmployee.getTitle());

            return employeeRepo.save(employee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + facultyId);
        }
    }

    public String assignFacultyToCourse(String token, CourseUpdateRequest request) {
        Long facultyId = jwtHelper.extractEmployeeId(token);
        if (facultyId == null) {
            return "Could not found given employee_id";
        }
        Courses course = courseRepository.findByCourseName(request.getCourseName())
                .orElseThrow(() -> new RuntimeException("Course not found with name: " + request.getCourseName()));

        int courseId = course.getCourse_id();

//        Optional<Faculty_Courses> existingAssignment = facultyCourseRepository
//                .findByCourseIdAndFacultyId(courseId, facultyId);
//
//        if (existingAssignment.isPresent()) {
//            throw new RuntimeException("Course is already assigned to this faculty.");
//        }



//        // Remove existing assignments for the course
//        List<Faculty_Courses> existingAssignments = facultyCourseRepository.findByCourseId(courseId);
//        facultyCourseRepository.deleteAll(existingAssignments);

        // Create new assignment
        Faculty_Courses facultyCourse = new Faculty_Courses();
        facultyCourse.setCourseId(courseId);
        facultyCourse.setFacultyId(facultyId.intValue());
        facultyCourseRepository.save(facultyCourse);
        return "Courses assigned to faculty successfully";
    }

    public String deleteFacultyCourse(String token, CourseUpdateRequest request) {
        Long facultyId = jwtHelper.extractEmployeeId(token);
        if (facultyId == null) {
            return "Could not found given employee_id";
        }

        Courses course = courseRepository.findByCourseName(request.getCourseName())
                .orElseThrow(() -> new RuntimeException("Course not found with name: " + request.getCourseName()));

        int courseId = course.getCourse_id();
//        System.out.println("-----============================--");
//        System.out.println(courseId);
//        System.out.println(facultyId);

//
        Faculty_Courses facultyCourse = facultyCourseRepository
                .findByCourseIdAndFacultyId(courseId,facultyId.intValue())
                .orElseThrow(() -> new RuntimeException("Course not found for the faculty"));

        facultyCourseRepository.delete(facultyCourse);
        return "Courses deleted related to faculty successfully";
    }

    public Employee getEmployee_(Long employeeId) {

        return employeeRepo.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        format("Cannot update Customer:: No employee found with the provided ID:: %s", employeeId)
                ));
    }

    public ResponseEntity<getEmployeeResponse> getEmployeeById(String token) {
        Long facultyId = jwtHelper.extractEmployeeId(token);

        // Fetch the employee entity from the database
        Employee employee = employeeRepo.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Employee not found for ID: " + facultyId));

        // Map the employee entity to the response DTO
        getEmployeeResponse response = employeeMapper.toEmployeeResponse(employee);
        return ResponseEntity.ok(response);

//       return employeeRepo.findById(facultyId);

    }
}







