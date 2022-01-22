package com.hrms.hrmsproject.entity.dtos.EducationDto;

import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.cv.Education;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EducationDtoConv {

    public Education convertToEducation(EducationReq educationReq, Cv cv){
        return new Education(
                cv,
                educationReq.getSchoolName(),
                educationReq.getDepartment(),
                educationReq.getStartDate(),
                educationReq.getEndDate(),
                LocalDateTime.now()
        );
    }

    public List<Education> convertToListEducation(List<EducationReq> educationReqs,Cv cv){
        return educationReqs.stream()
                .map(educationReq -> convertToEducation(educationReq,cv))
                .collect(Collectors.toList());
    }

    public EducationResponse convertToEducationResponse(Education education){
        return new EducationResponse(
                education.getId(),
                education.getSchoolName(),
                education.getDepartment(),
                education.getStartDate(),
                education.getEndDate()
        );
    }

    public List<EducationResponse> convertToListEducationResponse(List<Education> educations){
        return educations.stream()
                .map(this::convertToEducationResponse)
                .collect(Collectors.toList());
    }

}
