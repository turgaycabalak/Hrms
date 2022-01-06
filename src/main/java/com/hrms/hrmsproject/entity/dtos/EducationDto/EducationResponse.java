package com.hrms.hrmsproject.entity.dtos.EducationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EducationResponse {

    private Long id;
    private String schoolName;
    private String department;
    private LocalDate startDate;
    private LocalDate endDate;

}
