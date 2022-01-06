package com.hrms.hrmsproject.business.CvServices;

import com.hrms.hrmsproject.business.JobAdvertisementService.JobPositionService;
import com.hrms.hrmsproject.dataAccess.CvRepos.JobExperienceRepository;
import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.cv.JobExperience;
import com.hrms.hrmsproject.entity.dtos.JobExperienceDto.JobExperienceDtoConv;
import com.hrms.hrmsproject.entity.dtos.JobExperienceDto.JobExperienceReq;
import com.hrms.hrmsproject.entity.dtos.JobExperienceDto.JobExperienceResponse;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobPosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JobExperienceService {

    private final JobExperienceRepository jobExperienceRepository;
    private final CvService cvService;
    private final JobPositionService jobPositionService;
    private final JobExperienceDtoConv jobExperienceDtoConv;


    public JobExperienceResponse addJobExperience(JobExperienceReq jobExperienceReq, Long cvId) {
        Cv cv = cvService.findCvById(cvId);
        JobPosition jobPosition = jobPositionService.findJobPositionById(jobExperienceReq.getJobPositionId());
        JobExperience jobExperienceWillAdd = jobExperienceDtoConv.convertToJobExperience(jobExperienceReq,cv,jobPosition);

        JobExperience jobExperienceAdded = jobExperienceRepository.save(jobExperienceWillAdd);
        return jobExperienceDtoConv.convertToJobExperienceResponse(jobExperienceAdded);
    }
}
