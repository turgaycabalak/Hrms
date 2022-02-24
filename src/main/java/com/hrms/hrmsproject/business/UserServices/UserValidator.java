package com.hrms.hrmsproject.business.UserServices;

import com.hrms.hrmsproject.core.exceptions.PasswordsNotMatchingException;
import com.hrms.hrmsproject.dataAccess.UserRepos.UserRepository;
import com.hrms.hrmsproject.entity.dtos.UserDto.UserValidationDto;

import java.util.function.Consumer;


public interface UserValidator extends Consumer<UserValidationDto> {



    static UserValidator isPasswordMatching(){
        return dto -> {
            if(!dto.getPassword().equals(dto.getPasswordRepeat())){
                throw new PasswordsNotMatchingException("Passwords are not matching!");
            }
        };
    }

//    static UserValidator isEmailAlreadyTaken(){
//        return dto -> {
//            if (){
//        }
//    }



//    enum ValidationResult {
//        SUCCESS,
//        PASSWORD_NOT_MATCHING,
//        EMAIL_ALREADY_TAKEN
//    }

}
