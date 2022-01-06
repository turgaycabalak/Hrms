package com.hrms.hrmsproject.business.UserServices;

import com.hrms.hrmsproject.core.exceptions.EmailAlreadyInUseException;
import com.hrms.hrmsproject.core.exceptions.PasswordsNotMatchingException;
import com.hrms.hrmsproject.dataAccess.UserRepos.UserRepository;
import com.hrms.hrmsproject.entity.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void validateUserEmailAndPassword(String password, String passwordRepeat, String email){
        if(!password.equals(passwordRepeat)){
            throw new PasswordsNotMatchingException("Passwords are not matching!");
        }
        if(userRepository.findByEmail(email).isPresent()){
            throw new EmailAlreadyInUseException("This email is already taken!");
        }
    }




}
