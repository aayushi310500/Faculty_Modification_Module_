package com.restaurant.faculty_modify.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedEmployeeResponse {

//    private Integer department;
    private String firstName;
    private String lastName;
    private String photographPath;
    private String title;

}
