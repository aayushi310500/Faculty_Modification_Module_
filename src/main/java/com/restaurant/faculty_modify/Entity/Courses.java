package com.restaurant.faculty_modify.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="courses")

public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int course_id;

    @Column(name = "course_code", nullable = false)
    private String courseCode;

    @Column(name = "name", nullable = false)
    private String courseName;

    @Column(name = "description", nullable = false)
    private String courseDescription;

    @Column(name = "year", nullable = false)
    private int courseYear;

    @Column(name = "term", nullable = false)
    private String courseTerm;

    @Column(name = "faculty", nullable = false)
    private String courseFaculty;

    @Column(name = "credits", nullable = false)
    private int courseCredits;

    @Column(name = "capacity", nullable = false)
    private int courseCapacity;
}

