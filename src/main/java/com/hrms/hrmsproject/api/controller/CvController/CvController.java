package com.hrms.hrmsproject.api.controller.CvController;

import com.hrms.hrmsproject.business.CvServices.*;
import com.hrms.hrmsproject.entity.dtos.CvDto.CvReq;
import com.hrms.hrmsproject.entity.dtos.CvDto.CvReq2;
import com.hrms.hrmsproject.entity.dtos.EducationDto.EducationReq;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageReq;
import com.hrms.hrmsproject.entity.dtos.JobExperienceDto.JobExperienceReq;
import com.hrms.hrmsproject.entity.dtos.SkillDto.SkillReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RequiredArgsConstructor
@RestController
@RequestMapping("cvs")
@Validated
public class CvController {

    private final CvService cvService;
    private final EducationService educationService;
    private final ForeignLanguageService foreignLanguageService;
    private final JobExperienceService jobExperienceService;
    private final SkillService skillService;

    private final String NOT_VALID_ID = "ID should be greater than 0!";



    @PostMapping("savecv")
    public ResponseEntity<?> saveCv(@Valid @RequestBody CvReq cvReq){
        return new ResponseEntity<>(cvService.saveCv(cvReq), HttpStatus.CREATED);
    }

    @PostMapping("savecv2")
    public ResponseEntity<?> saveCv2(@Valid @RequestBody CvReq2 cvReq2){
        return new ResponseEntity<>(cvService.saveCv2(cvReq2), HttpStatus.CREATED);
    }

////////////////////////////////////  ADD  ////////////////////////////////////
    @PostMapping("addeducation")
    public ResponseEntity<?> addEducation(@Valid @RequestBody EducationReq educationReq,
                                          @RequestParam @Min(value = 1,message = NOT_VALID_ID)  Long cvId){
        return new ResponseEntity<>(educationService.addEducation(educationReq, cvId), HttpStatus.CREATED);
    }

    @PostMapping("addforeignlanguage")
    public ResponseEntity<?> addForeignLanguage(@Valid @RequestBody ForeignLanguageReq foreignLanguageReq,
                                                @RequestParam @Min(value = 1,message = NOT_VALID_ID)  Long cvId){
        return new ResponseEntity<>(foreignLanguageService.addForeignLanguage(foreignLanguageReq, cvId), HttpStatus.CREATED);
    }

    @PostMapping("addjobexperience")
    public ResponseEntity<?> addJobExperience(@Valid @RequestBody JobExperienceReq jobExperienceReq,
                                              @RequestParam @Min(value = 1,message = NOT_VALID_ID)  Long cvId){
        return new ResponseEntity<>(jobExperienceService.addJobExperience(jobExperienceReq, cvId), HttpStatus.CREATED);
    }

    @PostMapping("addskill")
    public ResponseEntity<?> addSkill(@Valid @RequestBody SkillReq skillReq,
                                      @RequestParam @Min(value = 1,message = NOT_VALID_ID)  Long cvId){
        return new ResponseEntity<>(skillService.addSkill(skillReq, cvId), HttpStatus.CREATED);
    }
//////////////////////////////////////////////////////////////////////////////

    @GetMapping("cvsbycandidateid")
    public ResponseEntity<?> findAllCvsByCandidateId(@RequestParam @Min(value = 1,message = NOT_VALID_ID)  Long candidateId){
        return ResponseEntity.ok(cvService.findAllCvsByCandidateId(candidateId));
    }




}