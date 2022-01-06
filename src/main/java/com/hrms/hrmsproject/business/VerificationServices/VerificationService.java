package com.hrms.hrmsproject.business.VerificationServices;

import com.hrms.hrmsproject.core.exceptions.AlreadyVerifiedException;
import com.hrms.hrmsproject.core.exceptions.VerificationExpiredException;
import com.hrms.hrmsproject.core.exceptions.VerificationNotFoundException;
import com.hrms.hrmsproject.dataAccess.VerificationRepos.VerificationRepo;
import com.hrms.hrmsproject.entity.verification.Verification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VerificationService {

    private final VerificationRepo verificationRepo;


    protected Verification findVerificationByCode(String code){
        return verificationRepo.findByCode(code)
                .orElseThrow(() -> new VerificationNotFoundException("Verification code not found"));
    }


    public void verifyCode(String code) {
        Verification verification = findVerificationByCode(code);

        if(verification.isVerified() || verification.getVerifiedDate() != null){
            throw new AlreadyVerifiedException("This verification code has already been verified!");
        }

        if (verification.getExpirationDate().isBefore(LocalDateTime.now())){
            throw new VerificationExpiredException("This verification code expired!");
        }

        verificationRepo.updateVerification(code, LocalDateTime.now());
    }



}
