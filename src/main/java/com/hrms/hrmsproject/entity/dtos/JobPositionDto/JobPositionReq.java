package com.hrms.hrmsproject.entity.dtos.JobPositionDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class JobPositionReq {

    @NotBlank(message = "Position name is required!")
    @NotNull
    private String positionName;

}
