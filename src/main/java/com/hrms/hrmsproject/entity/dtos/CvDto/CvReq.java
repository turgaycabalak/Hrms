package com.hrms.hrmsproject.entity.dtos.CvDto;

import com.hrms.hrmsproject.entity.dtos.EducationDto.EducationReq;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageReq;
import com.hrms.hrmsproject.entity.dtos.JobExperienceDto.JobExperienceReq;
import com.hrms.hrmsproject.entity.dtos.SkillDto.SkillReq;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import java.util.List;

@Data
@AllArgsConstructor
public class CvReq {

    @Min(value = 1,message = "Candidate Id is required!")
    private Long candidateId;

    private String photo;
    private String coverLetter;
    private String gitHub;
    private String linkedIn;


    private List<EducationReq> educationReqs;
    private List<JobExperienceReq> jobExperienceReqs;
    private List<ForeignLanguageReq> foreignLanguageReqs;
    private List<SkillReq> skillReqs;

}
