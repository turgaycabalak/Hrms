package com.hrms.hrmsproject.business.CvServices;

import com.hrms.hrmsproject.dataAccess.CvRepos.EducationRepository;
import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.cv.Education;
import com.hrms.hrmsproject.entity.dtos.EducationDto.EducationDtoConv;
import com.hrms.hrmsproject.entity.dtos.EducationDto.EducationReq;
import com.hrms.hrmsproject.entity.dtos.EducationDto.EducationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;
    private final CvService cvService;
    private final EducationDtoConv educationDtoConv;


    public EducationResponse addEducation(EducationReq educationReq, Long cvId) {
        Cv cv = cvService.findCvById(cvId);
        Education educationWillAdd = educationDtoConv.convertToEducation(educationReq,cv);

        Education educationAdded = educationRepository.save(educationWillAdd);
        return educationDtoConv.convertToEducationResponse(educationAdded);
    }

}
