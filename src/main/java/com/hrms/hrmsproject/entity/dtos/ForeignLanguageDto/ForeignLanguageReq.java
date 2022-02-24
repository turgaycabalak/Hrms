package com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ForeignLanguageReq {

    @Min(value = 1,message = "Language is required!")
    @NotNull(message = "Language is required!")
    private Long languageId;

    @Min(value = 1,message = "Language level should be between 1-5!")
    @Max(value = 5,message = "Language level should be between 1-5!")
    private int level;

}
