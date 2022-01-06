package com.hrms.hrmsproject.business.CvServices;

import com.hrms.hrmsproject.business.JobAdvertisementService.JobPositionService;
import com.hrms.hrmsproject.business.UserServices.CandidateService;
import com.hrms.hrmsproject.dataAccess.CvRepos.CvRepository;
import com.hrms.hrmsproject.entity.cv.*;
import com.hrms.hrmsproject.entity.dtos.CvDto.CvDtoConv;
import com.hrms.hrmsproject.entity.dtos.CvDto.CvReq;
import com.hrms.hrmsproject.entity.dtos.CvDto.CvReq2;
import com.hrms.hrmsproject.entity.dtos.CvDto.CvResponse;
import com.hrms.hrmsproject.entity.dtos.EducationDto.EducationDtoConv;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageDtoConv;
import com.hrms.hrmsproject.entity.dtos.JobExperienceDto.JobExperienceDtoConv;
import com.hrms.hrmsproject.entity.dtos.JobExperienceDto.JobExperienceReq;
import com.hrms.hrmsproject.entity.dtos.SkillDto.SkillDtoConv;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobPosition;
import com.hrms.hrmsproject.entity.users.Candidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CvService {

    private final CvRepository cvRepository;
    private final CandidateService candidateService;
    private final JobPositionService jobPositionService;
    private final CvDtoConv cvDtoConv;
    private final EducationDtoConv educationDtoConv;
    private final JobExperienceDtoConv jobExperienceDtoConv;
    private final ForeignLanguageDtoConv foreignLanguageDtoConv;
    private final SkillDtoConv skillDtoConv;


    public CvResponse saveCv(CvReq cvReq) {
        Candidate candidate = candidateService.findCandidateById(cvReq.getCandidateId());
        Cv cvWillSaveDb = cvDtoConv.convertToCv(cvReq,candidate);

        if(cvReq.getEducationReqs() != null){
            List<Education> educations = educationDtoConv.convertToListEducation(cvReq.getEducationReqs(),cvWillSaveDb);

            cvWillSaveDb.setEducations(educations);
        }
        if(cvReq.getJobExperienceReqs() != null){
            List<JobExperience> jobExperiences = new ArrayList<>();
            List<JobExperienceReq> jobExperienceReqs = cvReq.getJobExperienceReqs();

            jobExperienceReqs.forEach(jobExperienceReq -> {
                JobPosition jobPosition = jobPositionService.findJobPositionById(jobExperienceReq.getJobPositionId());
                jobExperiences.add(jobExperienceDtoConv.convertToJobExperience(jobExperienceReq,cvWillSaveDb,jobPosition));
            });

            cvWillSaveDb.setJobExperiences(jobExperiences);
        }
        if(cvReq.getForeignLanguageReqs() != null){
            List<ForeignLanguage> foreignLanguages = foreignLanguageDtoConv.convertToListForeignLanguage(cvReq.getForeignLanguageReqs(),cvWillSaveDb);

            cvWillSaveDb.setForeignLanguages(foreignLanguages);
        }
        if(cvReq.getSkillReqs() != null){
            List<Skill> skills = skillDtoConv.convertToListSkill(cvReq.getSkillReqs(),cvWillSaveDb);

            cvWillSaveDb.setSkills(skills);
        }

        Cv savedCv = cvRepository.save(cvWillSaveDb);
        return cvDtoConv.convertToCvResponse(savedCv);
    }


    public Cv findCvById(Long cvId) {
        return cvRepository.findById(cvId)
                .orElseThrow(() -> new IllegalStateException("Cv not found!"));
    }

    public List<CvResponse> findAllCvsByCandidateId(Long candidateId) {
        List<Cv> cvs = cvRepository.findByCandidateId(candidateId);

        return cvDtoConv.convertToListCvResponse(cvs);
    }

    public CvResponse saveCv2(CvReq2 cvReq2) {
        Candidate candidate = candidateService.findCandidateById(cvReq2.getCandidateId());
        Cv cvWillSaveDb = cvDtoConv.convertToCv2(cvReq2,candidate);

        Cv savedCv = cvRepository.save(cvWillSaveDb);
        return cvDtoConv.convertToCvResponse(savedCv);
    }

}
