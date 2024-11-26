package com.restaurant.faculty_modify.Controller;


import com.restaurant.faculty_modify.DTO.*;
import com.restaurant.faculty_modify.Entity.Employee;
import com.restaurant.faculty_modify.Helper.JWTAuthValidate;
import com.restaurant.faculty_modify.Helper.JWTHelper;
import com.restaurant.faculty_modify.Mapper.EmployeeMapper;
import com.restaurant.faculty_modify.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1")
@RequiredArgsConstructor
@RestController
public class EmployeeController {


    private final EmployeeService employeeService;
   private final JWTAuthValidate jwtauthValidate;
   private  final JWTHelper jwtHelper;
    private final EmployeeMapper employeeMapper;
//   private final CourseUpdateRequest courseUpdateRequest;



    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.create(employee));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok((employeeService.login(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdatedEmployeeResponse> updateEmployee( @RequestHeader("Authorization") String authHeader, @RequestBody Employee updatedEmployee) {
//        return employeeService.updateEmployee(id, updatedEmployee);
        String token = jwtHelper.removeBearerFromToken(authHeader);


        if (!jwtHelper.validateToken(token)) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }

        try {
            // Call service method to update the employee
            Employee updated = employeeService.updateEmployee(token, updatedEmployee);
            UpdatedEmployeeResponse response = employeeMapper.toUpdateEmployeeResponse(updated);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            // Handle potential errors
            return ResponseEntity.status(400).body(null); // Bad Request
        }
       // return employeeService.updateEmployee(token, updatedEmployee);
    }

    @PutMapping("/assign")
    public ResponseEntity<String> assignFacultyToCourse(
                                                        @RequestHeader("Authorization") String authHeader, @RequestBody CourseUpdateRequest request) {

        String token = jwtHelper.removeBearerFromToken(authHeader);

        if (!jwtHelper.validateToken(token)) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }

        try {
            String result = employeeService.assignFacultyToCourse(token, request);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage()); // Handle Bad Request
        }

//        String result = employeeService.assignFacultyToCourse(token, request);
//        return ResponseEntity.ok(result);
    }

    @PutMapping ("/delete_course")
    public ResponseEntity<String> deleteFacultyCourse( @RequestHeader("Authorization") String authHeader, @RequestBody CourseUpdateRequest request) {
//        System.out.println("-----0-============================------------------");
//        return ResponseEntity.ok("OKK");
        String token = jwtHelper.removeBearerFromToken(authHeader);

        if (!jwtHelper.validateToken(token)) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }

        try {
            String result = employeeService.deleteFacultyCourse(token, request);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage()); // Handle Bad Request
        }
    }

    @GetMapping("/employee")
    public ResponseEntity<getEmployeeResponse> getEmployeeDetails(@RequestHeader("Authorization") String authHeader) {
        String token = jwtHelper.removeBearerFromToken(authHeader);

        if (!jwtHelper.validateToken(token)) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
        return employeeService.getEmployeeById(token);
//        try {
//            String result = employeeService.deleteFacultyCourse(token, request);
//            return ResponseEntity.ok(result);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(400).body(e.getMessage()); // Handle Bad Request
//        }
    }
}
