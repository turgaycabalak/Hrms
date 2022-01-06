package com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class JobAdvertisementCustomDto {

    private Long id;
    private String companyName;
    private String jobPositionName;
    private int openPositionNumber;
    private LocalDate createdDate;
    private LocalDate deadLine;

}
