package com.hrms.hrmsproject.entity.dtos.SkillDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class SkillReq {

    @NotBlank(message = "Skill name is required!")
    @NotNull
    private String skill;

    @Min(value = 1,message = "Language level should be between 1-5!")
    @Max(value = 5,message = "Language level should be between 1-5!")
    private int skillLevel;

}
