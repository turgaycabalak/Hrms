package com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto;

import com.hrms.hrmsproject.entity.jobAdvertisement.City;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobAdvertisement;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobPosition;
import com.hrms.hrmsproject.entity.users.Employer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobAdvertisementDtoConv {

    public JobAdvertisement convertToJobAdvertisement(JobAdvertisementReq jobAdvertisementReq,
                                                      JobPosition jobPosition,
                                                      City city,
                                                      Employer employer){
        return new JobAdvertisement(
                jobPosition,
                jobAdvertisementReq.getJobDescription(),
                city,
                jobAdvertisementReq.getMinSalary(),
                jobAdvertisementReq.getMaxSalary(),
                jobAdvertisementReq.getOpenPositionNumber(),
                jobAdvertisementReq.getDeadLine(),
                LocalDate.now(),
                true,
                employer
        );
    }

    public JobAdvertisementResponse convertToJobAdvertisementResponse(JobAdvertisement jobAdvertisement){
        return new JobAdvertisementResponse(
                jobAdvertisement.getId(),
                jobAdvertisement.getJobPosition().getPositionName(),
                jobAdvertisement.getJobDescription(),
                jobAdvertisement.getCity().getCityName(),
                jobAdvertisement.getMinSalary(),
                jobAdvertisement.getMaxSalary(),
                jobAdvertisement.getOpenPositionNumber(),
                jobAdvertisement.getDeadLine(),
                jobAdvertisement.getCreatedDate(),
                jobAdvertisement.getEmployer().getCompanyName(),
                jobAdvertisement.getEmployer().getWebAddress(),
                jobAdvertisement.getEmployer().getEmail(),
                jobAdvertisement.getEmployer().getPhoneNumber()
        );
    }

    public List<JobAdvertisementResponse> convertToListJobAdvertisementResponse(List<JobAdvertisement> jobAdvertisements){
        List<JobAdvertisementResponse> jobAdvertisementResponses = new ArrayList<>();

        jobAdvertisements.forEach(jobAdvertisement -> jobAdvertisementResponses
                .add(convertToJobAdvertisementResponse(jobAdvertisement)));

        return jobAdvertisementResponses;
    }

}
