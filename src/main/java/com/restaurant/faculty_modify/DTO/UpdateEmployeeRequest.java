package com.restaurant.faculty_modify.DTO;

import com.restaurant.faculty_modify.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@Data
public class UpdateEmployeeRequest {

      //  private Integer employeeId;  // Employee ID to identify the faculty
        private String firstName;    // Employee First Name
        private String lastName;     // Employee Last Name
      //   private String email;        // Employee Email
        private String photographPath; // Path to the photograph
      //  private String courseName;   // Single course name (from dropdown)
        private String title;
        // Getters and Setters

}
