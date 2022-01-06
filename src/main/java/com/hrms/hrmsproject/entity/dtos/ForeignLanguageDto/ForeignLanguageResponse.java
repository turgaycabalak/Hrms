package com.hrms.hrmsproject.entity.dtos.ForeignLanguageDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForeignLanguageResponse {

    private Long id;
    private String language;
    private int level;

}
