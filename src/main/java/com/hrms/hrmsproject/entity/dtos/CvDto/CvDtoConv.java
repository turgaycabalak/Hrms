package com.hrms.hrmsproject.entity.dtos.CvDto;

import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.dtos.EducationDto.EducationDtoConv;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageDtoConv;
import com.hrms.hrmsproject.entity.dtos.JobExperienceDto.JobExperienceDtoConv;
import com.hrms.hrmsproject.entity.dtos.SkillDto.SkillDtoConv;
import com.hrms.hrmsproject.entity.users.Candidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CvDtoConv {

    private final EducationDtoConv educationDtoConv;
    private final JobExperienceDtoConv jobExperienceDtoConv;
    private final ForeignLanguageDtoConv foreignLanguageDtoConv;
    private final SkillDtoConv skillDtoConv;


    public Cv convertToCv(CvReq cvReq, Candidate candidate){
        return new Cv(
                candidate,
                cvReq.getPhoto(),
                cvReq.getCoverLetter(),
                cvReq.getGitHub(),
                cvReq.getLinkedIn(),
                LocalDateTime.now()
        );
    }

    public CvResponse convertToCvResponse(Cv cv){
        CvResponse cvResponse = new CvResponse(
                cv.getId(),
                cv.getCandidate().getFirstName(),
                cv.getCandidate().getLastName(),
                cv.getPhoto(),
                cv.getCoverLetter(),
                cv.getGitHub(),
                cv.getLinkedIn(),
                cv.getCreatedDate(),
                cv.getUpdatedDate()
        );


        if (cv.getEducations() != null){
            cvResponse.setEducations(educationDtoConv.convertToListEducationResponse(cv.getEducations()));
        }
        if (cv.getJobExperiences() != null){
            cvResponse.setJobExperiences(jobExperienceDtoConv.convertToListJobExperienceResponse(cv.getJobExperiences()));
        }
        if (cv.getForeignLanguages() != null){
            cvResponse.setForeignLanguages(foreignLanguageDtoConv.convertToListForeignLanguageResponse(cv.getForeignLanguages()));
        }
        if(cv.getSkills() != null){
            cvResponse.setSkills(skillDtoConv.convertToListSkillResponse(cv.getSkills()));
        }

        return cvResponse;
    }

    public List<CvResponse> convertToListCvResponse(List<Cv> cvs){
        return cvs.stream()
                .map(this::convertToCvResponse)
                .collect(Collectors.toList());
    }

/////////////////////////  CvReq2 Type converters  //////////////////////////////
    public Cv convertToCv2(CvReq2 cvReq2, Candidate candidate){
        return new Cv(
                candidate,
                cvReq2.getPhoto(),
                cvReq2.getCoverLetter(),
                cvReq2.getGitHub(),
                cvReq2.getLinkedIn(),
                LocalDateTime.now()
        );
    }



}
