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
@Table(name="faculty_courses")
public class Faculty_Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "faculty_id", nullable = false)
    private int facultyId;

    @Column(name = "course_id", nullable = false)
    private int courseId;

}
