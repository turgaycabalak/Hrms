package com.hrms.hrmsproject.entity.dtos.CvDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class CvReq2 {

    @Min(value = 1,message = "Candidate Id is required!")
    private Long candidateId;

    private String photo;
    private String coverLetter;
    private String gitHub;
    private String linkedIn;

}
