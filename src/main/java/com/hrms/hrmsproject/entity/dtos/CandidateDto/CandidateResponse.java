package com.hrms.hrmsproject.entity.dtos.CandidateDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CandidateResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime createdTime;

}
