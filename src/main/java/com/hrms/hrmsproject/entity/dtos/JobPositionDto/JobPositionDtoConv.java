package com.hrms.hrmsproject.entity.dtos.JobPositionDto;

import com.hrms.hrmsproject.entity.jobAdvertisement.JobPosition;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobPositionDtoConv {

    public JobPosition convertToJobPosition(JobPositionReq jobPositionReq){
        return new JobPosition(
                jobPositionReq.getPositionName()
        );
    }

    public JobPositionResponse convertToJobPositionResponse(JobPosition jobPosition){
        return new JobPositionResponse(
                jobPosition.getId(),
                jobPosition.getPositionName()
        );
    }

    public List<JobPositionResponse> convertToListJobPositionResponse(List<JobPosition> jobPositions){
        List<JobPositionResponse> jobPositionResponses = new ArrayList<>();
        jobPositions.forEach(jobPosition -> jobPositionResponses.add(convertToJobPositionResponse(jobPosition)));

        return jobPositionResponses;
    }



}
