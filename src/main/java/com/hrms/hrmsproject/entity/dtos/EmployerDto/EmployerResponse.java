package com.hrms.hrmsproject.entity.dtos.EmployerDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EmployerResponse {

    private Long id;
    private String companyName;
    private String website;
    private String phoneNumber;
    private LocalDateTime createdTime;


}
