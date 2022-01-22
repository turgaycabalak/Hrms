package com.hrms.hrmsproject.entity.dtos.EmployeeDto;

import com.hrms.hrmsproject.entity.users.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDtoConv {

    public Employee convertToEmployee(EmployeeReq employeeReq){
        return new Employee(
                employeeReq.getEmail(),
                employeeReq.getPassword(),
                LocalDateTime.now(),
                employeeReq.getFirstName(),
                employeeReq.getLastName()
        );
    }

    public EmployeeResponse convertToEmployeeResp(Employee employee){
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getCreatedTime()
        );
    }

    public List<EmployeeResponse> convertToListEmployeeResponse(List<Employee> employees){
        return employees.stream()
                .map(this::convertToEmployeeResp)
                .collect(Collectors.toList());
    }



}
