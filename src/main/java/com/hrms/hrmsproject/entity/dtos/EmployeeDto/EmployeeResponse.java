package com.hrms.hrmsproject.entity.dtos.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EmployeeResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime createdTime;

}
