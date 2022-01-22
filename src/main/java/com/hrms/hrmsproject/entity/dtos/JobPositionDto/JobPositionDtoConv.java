package com.hrms.hrmsproject.entity.dtos.JobPositionDto;

import com.hrms.hrmsproject.entity.jobAdvertisement.JobPosition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobPositionDtoConv {

    public JobPositionResponse convertToJobPositionResponse(JobPosition jobPosition){
        return new JobPositionResponse(
                jobPosition.getId(),
                jobPosition.getPositionName()
        );
    }

    public List<JobPositionResponse> convertToListJobPositionResponse(List<JobPosition> jobPositions){
        return jobPositions.stream()
                .map(this::convertToJobPositionResponse)
                .collect(Collectors.toList());
    }



}
