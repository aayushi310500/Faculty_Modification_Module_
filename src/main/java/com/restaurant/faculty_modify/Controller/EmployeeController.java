package com.restaurant.faculty_modify.Controller;


import com.restaurant.faculty_modify.DTO.LoginRequest;
import com.restaurant.faculty_modify.Entity.Employee;
import com.restaurant.faculty_modify.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1")
@RequiredArgsConstructor
@RestController
public class EmployeeController {


    private final EmployeeService employeeService;
//    private final JwtAuthValidate jwtauthValidate;


    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.create(employee));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok((employeeService.login(request)));
    }

}
