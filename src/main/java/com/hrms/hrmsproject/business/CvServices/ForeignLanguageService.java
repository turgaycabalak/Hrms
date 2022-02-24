package com.hrms.hrmsproject.business.CvServices;

import com.hrms.hrmsproject.core.exceptions.LanguageAlreadyInCvException;
import com.hrms.hrmsproject.dataAccess.CvRepos.ForeignLanguageRepository;
import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.cv.ForeignLanguage;
import com.hrms.hrmsproject.entity.cv.Language;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageDtoConv;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageReq;
import com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto.ForeignLanguageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ForeignLanguageService {

    private final ForeignLanguageRepository foreignLanguageRepository;
    private final CvService cvService;
    private final ForeignLanguageDtoConv foreignLanguageDtoConv;
    private final LanguageService languageService;


    public ForeignLanguageResponse addForeignLanguage(ForeignLanguageReq foreignLanguageReq, Long cvId) {
        Cv cv = cvService.findCvById(cvId);
        Language language = languageService.findLanguageById(foreignLanguageReq.getLanguageId());

        cv.getForeignLanguages().forEach(foreignLanguage -> {
            if(foreignLanguage.getLanguage().getLanguageName().equals(language.getLanguageName())){
                throw new LanguageAlreadyInCvException("This language is already in your cv!");
            }
        });
        ForeignLanguage foreignLanguageWillAdd = foreignLanguageDtoConv
                .convertToForeignLanguage(foreignLanguageReq, language, cv);

        ForeignLanguage foreignLanguageAdded = foreignLanguageRepository.save(foreignLanguageWillAdd);
        return foreignLanguageDtoConv.convertToForeignLanguageResponse(foreignLanguageAdded);
    }
}
