package com.hrms.hrmsproject.business.JobAdvertisementService;

import com.hrms.hrmsproject.core.exceptions.JobPositionNotFoundException;
import com.hrms.hrmsproject.core.exceptions.PositionNameAlreadyExistException;
import com.hrms.hrmsproject.dataAccess.JobAdvertisementRepos.JobPositionRepo;
import com.hrms.hrmsproject.entity.dtos.JobPositionDto.JobPositionDtoConv;
import com.hrms.hrmsproject.entity.dtos.JobPositionDto.JobPositionResponse;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobPosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPositionService {

    private final JobPositionRepo jobPositionRepo;
    private final JobPositionDtoConv jobPositionDtoConv;



    public JobPositionResponse saveJobPosition(String positionName) {
        if(jobPositionRepo.findByPositionName(positionName.toUpperCase()).isPresent()){
            throw new PositionNameAlreadyExistException("Position name already exists!");
        }

        JobPosition savedJobPosition = jobPositionRepo.save(new JobPosition(positionName.toUpperCase()));
        return jobPositionDtoConv.convertToJobPositionResponse(savedJobPosition);
    }


    public List<JobPositionResponse> findAllJobPositions() {
        List<JobPosition> jobPositions = jobPositionRepo.findAll();

        return jobPositionDtoConv.convertToListJobPositionResponse(jobPositions);
    }


    public JobPosition findJobPositionById(Long jobPositionId) {
        return jobPositionRepo.findById(jobPositionId)
                .orElseThrow(() -> new JobPositionNotFoundException("Job position not found!"));
    }
}
