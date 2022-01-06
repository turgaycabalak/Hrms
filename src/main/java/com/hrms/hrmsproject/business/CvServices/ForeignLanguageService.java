package com.hrms.hrmsproject.business.CvServices;

import com.hrms.hrmsproject.dataAccess.CvRepos.ForeignLanguageRepository;
import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.cv.ForeignLanguage;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageDtoConv;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageReq;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ForeignLanguageService {

    private final ForeignLanguageRepository foreignLanguageRepository;
    private final CvService cvService;
    private final ForeignLanguageDtoConv foreignLanguageDtoConv;


    public ForeignLanguageResponse addForeignLanguage(ForeignLanguageReq foreignLanguageReq, Long cvId) {
        Cv cv = cvService.findCvById(cvId);
        ForeignLanguage foreignLanguageWillAdd = foreignLanguageDtoConv.convertToForeignLanguage(foreignLanguageReq,cv);

        ForeignLanguage foreignLanguageAdded = foreignLanguageRepository.save(foreignLanguageWillAdd);
        return foreignLanguageDtoConv.convertToForeignLanguageResponse(foreignLanguageAdded);
    }
}
