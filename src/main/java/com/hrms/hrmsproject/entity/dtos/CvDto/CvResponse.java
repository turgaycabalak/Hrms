package com.hrms.hrmsproject.entity.dtos.CvDto;

import com.hrms.hrmsproject.entity.dtos.EducationDto.EducationResponse;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageResponse;
import com.hrms.hrmsproject.entity.dtos.JobExperienceDto.JobExperienceResponse;
import com.hrms.hrmsproject.entity.dtos.SkillDto.SkillResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class CvResponse {

    private Long id;
    private String candidateFirstName;
    private String candidateLastName;
    private String photo;
    private String coverLetter;
    private String gitHub;
    private String linkedIn;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private List<EducationResponse> educations;
    private List<JobExperienceResponse> jobExperiences;
    private List<ForeignLanguageResponse> foreignLanguages;
    private List<SkillResponse> skills;


    public CvResponse(Long id,
                      String candidateFirstName,
                      String candidateLastName,
                      String photo,
                      String coverLetter,
                      String gitHub,
                      String linkedIn,
                      LocalDateTime createdDate,
                      LocalDateTime updatedDate) {
        this.id = id;
        this.candidateFirstName = candidateFirstName;
        this.candidateLastName = candidateLastName;
        this.photo = photo;
        this.coverLetter = coverLetter;
        this.gitHub = gitHub;
        this.linkedIn = linkedIn;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
