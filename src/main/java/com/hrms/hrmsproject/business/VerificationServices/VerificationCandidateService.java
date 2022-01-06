package com.hrms.hrmsproject.business.VerificationServices;

import com.hrms.hrmsproject.core.exceptions.VerificationNotFoundException;
import com.hrms.hrmsproject.dataAccess.VerificationRepos.VerificationCandidateRepo;
import com.hrms.hrmsproject.entity.verification.VerificationCandidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VerificationCandidateService {

    private final VerificationCandidateRepo verificationCandidateRepo;


    public void saveVerificationCandidate(VerificationCandidate verificationCandidate) {
        verificationCandidateRepo.save(verificationCandidate);
    }


    public List<VerificationCandidate> findAllByCandidateId(Long id) {
        return verificationCandidateRepo.findAllByCandidateId(id)
                .orElseThrow(() -> new VerificationNotFoundException("Any verification not found for this candidate id!"));
    }



}
