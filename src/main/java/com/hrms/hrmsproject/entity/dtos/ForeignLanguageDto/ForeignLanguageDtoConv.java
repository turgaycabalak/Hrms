package com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto;

import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.cv.ForeignLanguage;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ForeignLanguageDtoConv {

    public ForeignLanguage convertToForeignLanguage(ForeignLanguageReq foreignLanguageReq, Cv cv){
        return new ForeignLanguage(
                cv,
                foreignLanguageReq.getLanguage(),
                foreignLanguageReq.getLevel(),
                LocalDateTime.now()
        );
    }

    public List<ForeignLanguage> convertToListForeignLanguage(List<ForeignLanguageReq> foreignLanguageReqs,Cv cv){
        return foreignLanguageReqs.stream()
                .map(foreignLanguageReq -> convertToForeignLanguage(foreignLanguageReq,cv))
                .collect(Collectors.toList());
    }

    public ForeignLanguageResponse convertToForeignLanguageResponse(ForeignLanguage foreignLanguage){
        return new ForeignLanguageResponse(
                foreignLanguage.getId(),
                foreignLanguage.getLanguage(),
                foreignLanguage.getLevel()
        );
    }

    public List<ForeignLanguageResponse> convertToListForeignLanguageResponse(List<ForeignLanguage> foreignLanguages){
        return foreignLanguages.stream()
                .map(this::convertToForeignLanguageResponse)
                .collect(Collectors.toList());
    }

}
