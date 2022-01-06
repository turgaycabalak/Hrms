package com.hrms.hrmsproject.business.JobAdvertisementService;

import com.hrms.hrmsproject.business.UserServices.EmployerService;
import com.hrms.hrmsproject.core.exceptions.EmployerNotFoundException;
import com.hrms.hrmsproject.core.exceptions.JobAdvertisementAlreadyDisabledException;
import com.hrms.hrmsproject.core.exceptions.JobAdvertisementNotFoundException;
import com.hrms.hrmsproject.dataAccess.JobAdvertisementRepos.JobAdvertisementRepo;
import com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto.JobAdvertisementDtoConv;
import com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto.JobAdvertisementReq;
import com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto.JobAdvertisementResponse;
import com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto.JobAdvertisementCustomDto;
import com.hrms.hrmsproject.entity.jobAdvertisement.City;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobAdvertisement;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobPosition;
import com.hrms.hrmsproject.entity.users.Employer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobAdvertisementService {

    private final JobAdvertisementRepo jobAdvertisementRepo;
    private final JobPositionService jobPositionService;
    private final CityService cityService;
    private final EmployerService employerService;
    private final JobAdvertisementDtoConv jobAdvertisementDtoConv;



    public JobAdvertisementResponse saveJobAdvertisement(JobAdvertisementReq jobAdvertisementReq) {
        JobPosition jobPosition = jobPositionService.findJobPositionById(jobAdvertisementReq.getJobPositionId());
        City city = cityService.findCityById(jobAdvertisementReq.getCityId());
        Employer employer = employerService.findEmployerById(jobAdvertisementReq.getEmployerId());

        JobAdvertisement jobAdvertisementWillSaveDb = jobAdvertisementDtoConv
                .convertToJobAdvertisement(jobAdvertisementReq, jobPosition, city, employer);

        JobAdvertisement jobAdvertisementSaved = jobAdvertisementRepo.save(jobAdvertisementWillSaveDb);

        return jobAdvertisementDtoConv.convertToJobAdvertisementResponse(jobAdvertisementSaved);
    }


    private JobAdvertisement findJobAdvertisementById(Long jobAdvertisementId) {
        return jobAdvertisementRepo.findById(jobAdvertisementId)
                .orElseThrow(() -> new JobAdvertisementNotFoundException("Job advertisement not found!"));
    }

    public void deactivateJobAdvertisementById(Long jobAdvertisementId, Long employerId) {
        JobAdvertisement jobAdvertisement = findJobAdvertisementById(jobAdvertisementId);

        if(jobAdvertisement.getEmployer().getId() != employerId){
            throw new EmployerNotFoundException("Employer not found for this job advertisement!");
        }
        if(!jobAdvertisement.isActive()){
            throw new JobAdvertisementAlreadyDisabledException("Job advertisement already disabled!");
        }

        jobAdvertisementRepo.deactivateJobAdvertisementById(jobAdvertisementId);
    }


    public List<JobAdvertisementResponse> findAllActiveJobAdvertisements() {
        List<JobAdvertisement> activeJobAdvertisements = jobAdvertisementRepo.findByIsActive(true);
/////////////////////// Fazladan 2 defa select sorgusu calistiriyor !!!  ///////////////////////////////////
        return jobAdvertisementDtoConv.convertToListJobAdvertisementResponse(activeJobAdvertisements);
    }


    public List<JobAdvertisementCustomDto> findAllActiveJobAdvertisements2() {
        return jobAdvertisementRepo.findByIsActive2(true);
    }

    public List<JobAdvertisementCustomDto> findAllActiveJobAdvertisementsOrderByDate() {
        return jobAdvertisementRepo.findByIsActiveOrderedDate(true);
    }


    public List<JobAdvertisementCustomDto> findAllActiveJobAdvertisementsByCompanyName(String companyName) {
        return jobAdvertisementRepo.findByIsActiveAndCompanyName(companyName,true);
    }
}
