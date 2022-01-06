package com.hrms.hrmsproject.entity.dtos.CandidateDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class CandidateReq {

    @NotBlank(message = "Email is required!")
    @NotNull
    @Email(message = "Email should be correct format!")
    private String email;

    @NotBlank(message = "Password is required!")
    @NotNull
    @Size(min = 5,max = 25,message = "Password should be between 6 and 25 characters!")
    private String password;

    @NotBlank(message = "Password-repeat is required!")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordRepeat;

    @NotBlank(message = "First name is required!")
    @NotNull
    private String firstName;

    @NotBlank(message = "Last name is required!")
    @NotNull
    private String lastName;

    @NotBlank(message = "Identity number is required!")
    @NotNull
    @Size(min = 11,max = 11,message = "Identity number should be 11 characters!")
    private String identityNumber;

    @Min(value = 1900,message = "Birthday is required!")
    private int birthYear;


}
