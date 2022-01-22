package com.hrms.hrmsproject.entity.dtos.JobExperienceDto;

import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.cv.JobExperience;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobPosition;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobExperienceDtoConv {

    public JobExperience convertToJobExperience(JobExperienceReq jobExperienceReq, Cv cv, JobPosition jobPosition){
        return new JobExperience(
                cv,
                jobExperienceReq.getCompanyName(),
                jobPosition,
                jobExperienceReq.getStartDate(),
                jobExperienceReq.getEndDate(),
                LocalDateTime.now()
        );
    }

    public JobExperienceResponse convertToJobExperienceResponse(JobExperience jobExperience){
        return new JobExperienceResponse(
                jobExperience.getId(),
                jobExperience.getJobPosition().getPositionName(),
                jobExperience.getCompanyName(),
                jobExperience.getStartDate(),
                jobExperience.getEndDate()
        );
    }

    public List<JobExperienceResponse> convertToListJobExperienceResponse(List<JobExperience> jobExperiences){
        return jobExperiences.stream()
                .map(this::convertToJobExperienceResponse)
                .collect(Collectors.toList());
    }


}
