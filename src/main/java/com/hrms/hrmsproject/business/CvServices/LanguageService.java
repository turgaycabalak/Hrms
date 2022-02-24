package com.hrms.hrmsproject.business.CvServices;

import com.hrms.hrmsproject.dataAccess.CvRepos.LanguageRepository;
import com.hrms.hrmsproject.entity.cv.Language;
import com.hrms.hrmsproject.entity.dtos.LanguageDto.LanguageDtoConv;
import com.hrms.hrmsproject.entity.dtos.LanguageDto.LanguageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageDtoConv languageDtoConv;


    public LanguageResponse saveLanguage(String languageName) {
        if (languageRepository.findByLanguageName(languageName.toUpperCase()).isPresent()){
            throw new IllegalStateException("Language name already exists!");
        }
        Language savedLanguage = languageRepository.save(new Language(languageName.toUpperCase()));
        return languageDtoConv.convertToLanguageResponse(savedLanguage);
    }

    public List<LanguageResponse> findAllLanguages() {
        List<Language> languages = languageRepository.findAll();
        return languageDtoConv.convertToListLanguageResponse(languages);
    }

    public Language findLanguageById(Long languageId){
        return languageRepository.findById(languageId)
                .orElseThrow(() -> new IllegalStateException("Language not found!"));
    }
}
