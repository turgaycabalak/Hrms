package com.hrms.hrmsproject.api.controller.CvController;

import com.hrms.hrmsproject.business.CvServices.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@RestController
@RequestMapping("languages")
@Validated
public class LanguageController {

    private final LanguageService languageService;

    private final String NOT_BLANK_MESSAGE = "Language name is required!";


    @PostMapping("addlanguage")
    public ResponseEntity<?> addLanguage(@RequestParam
                                            @NotBlank(message = NOT_BLANK_MESSAGE)
                                            @NotNull(message = NOT_BLANK_MESSAGE) String languageName){
        return new ResponseEntity<>(languageService.saveLanguage(languageName), HttpStatus.CREATED);
    }

    @GetMapping("findallanguages")
    public ResponseEntity<?> findAllLanguages(){
        return ResponseEntity.ok(languageService.findAllLanguages());
    }

}
