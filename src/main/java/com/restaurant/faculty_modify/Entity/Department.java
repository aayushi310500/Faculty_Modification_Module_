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
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int department_id;

    @Column(name = "name", nullable = false)
    private String departmentName;

    @Column(name = "capacity", nullable = false)
    private int departmentCapacity;

}
