package com.restaurant.faculty_modify.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class getEmployeeResponse {

    private Integer department;
    private String firstName;
    private String lastName;
    private String photographPath;
    private String title;

    public getEmployeeResponse(Integer department, String firstName, String lastName, String photographPath, String title) {

        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photographPath = photographPath;
        this.title = title;
    }
}
