package com.hrms.hrmsproject.entity.dtos.LanguageDto;

import com.hrms.hrmsproject.entity.cv.Language;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LanguageDtoConv {

    public LanguageResponse convertToLanguageResponse(Language language){
        return new LanguageResponse(
                language.getId(),
                language.getLanguageName()
        );
    }

    public List<LanguageResponse> convertToListLanguageResponse(List<Language> languages){
        return languages.stream()
                .map(this::convertToLanguageResponse)
                .collect(Collectors.toList());
    }

}
