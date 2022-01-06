package com.hrms.hrmsproject.entity.dtos.SkillDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SkillResponse {

    private Long id;
    private String skill;
    private int skillLevel;

}
