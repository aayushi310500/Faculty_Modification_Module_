package com.restaurant.faculty_modify.Mapper;

import com.restaurant.faculty_modify.DTO.UpdatedEmployeeResponse;
import com.restaurant.faculty_modify.DTO.getEmployeeResponse;
import com.restaurant.faculty_modify.Entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public getEmployeeResponse toEmployeeResponse(Employee employee) {
        return new getEmployeeResponse(employee.getDepartment(),employee.getFirstName(),employee.getLastName(),employee.getPhotographPath(),employee.getTitle());
    }
    public UpdatedEmployeeResponse toUpdateEmployeeResponse(Employee employee) {
        return new UpdatedEmployeeResponse(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPhotographPath(),
                employee.getTitle()
        );
    }
}
