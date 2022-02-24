package com.hrms.hrmsproject.entity.dtos.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserValidationDto {

    private final String email;
    private final String password;
    private final String passwordRepeat;

}
