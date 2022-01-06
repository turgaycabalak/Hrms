package com.hrms.hrmsproject.business.VerificationServices;

import com.hrms.hrmsproject.core.exceptions.VerificationNotFoundException;
import com.hrms.hrmsproject.dataAccess.VerificationRepos.VerificationEmployerRepo;
import com.hrms.hrmsproject.entity.verification.VerificationEmployer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VerificationEmployerService {

    private final VerificationEmployerRepo verificationEmployerRepo;


    public void saveVerificationEmployer(VerificationEmployer verificationEmployer) {
        verificationEmployerRepo.save(verificationEmployer);
    }

    public List<VerificationEmployer> findAllByEmployerId(Long id) {
        return verificationEmployerRepo.findAllByEmployerId(id)
                .orElseThrow(() -> new VerificationNotFoundException("Any verification for employer not found for this id!"));
    }



}
