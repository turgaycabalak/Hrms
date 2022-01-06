package com.hrms.hrmsproject.business.UserServices;

import com.hrms.hrmsproject.business.VerificationServices.VerificationCandidateService;
import com.hrms.hrmsproject.core.emailSender.EmailBuilder;
import com.hrms.hrmsproject.core.emailSender.EmailSender;
import com.hrms.hrmsproject.core.exceptions.*;
import com.hrms.hrmsproject.dataAccess.UserRepos.CandidateRepository;
import com.hrms.hrmsproject.entity.dtos.CandidateDto.CandidateDtoConv;
import com.hrms.hrmsproject.entity.dtos.CandidateDto.CandidateReq;
import com.hrms.hrmsproject.entity.dtos.CandidateDto.CandidateResponse;
import com.hrms.hrmsproject.entity.users.Candidate;
import com.hrms.hrmsproject.entity.verification.VerificationCandidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final VerificationCandidateService verificationCandidateService;
    private final UserService userService;
    private final CandidateDtoConv candidateDtoConv;
    private final EmailSender emailSender;
    private final EmailBuilder emailBuilder;
    private String code;


    protected VerificationCandidate createVerificationCandidate(Candidate candidateWillSaveDb){
        code = UUID.randomUUID().toString();
        return new VerificationCandidate(
                code,
                false,
                LocalDateTime.now().plusMinutes(15),
                candidateWillSaveDb
        );
    }

    protected void sendEmail(String email,String firstName){
        String verificationLink = "http://localhost:8080/verification/verify?code="+code;
        emailSender.send(email,emailBuilder.buildEmail(firstName,verificationLink));
    }


    public CandidateResponse saveCandidate(CandidateReq candidateReq) {
        userService.validateUserEmailAndPassword(
                candidateReq.getPassword(),
                candidateReq.getPasswordRepeat(),
                candidateReq.getEmail()
        );
        if(candidateRepository.findByIdentityNumber(candidateReq.getIdentityNumber()).isPresent()){
            throw new IdentityNumberAlreadyInUseException("This identity number is already taken!");
        }

        Candidate candidateWillSaveDb = candidateDtoConv.convertToCandidate(candidateReq);

        VerificationCandidate verificationCandidate = createVerificationCandidate(candidateWillSaveDb);
        candidateWillSaveDb.setVerificationCandidates(Arrays.asList(verificationCandidate));

        Candidate candidateSaved = candidateRepository.save(candidateWillSaveDb);
/////////////
        sendEmail(candidateReq.getEmail(),candidateReq.getFirstName());
/////////////
        return candidateDtoConv.convertToCandidateResp(candidateSaved);
    }


    protected Candidate findCandidateByEmail(String email){
        return candidateRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Email doesn't exist!"));
    }

    public void reProduceVerificationCandidate(String email)  {
        Candidate candidate = findCandidateByEmail(email);
        List<VerificationCandidate> vList = verificationCandidateService.findAllByCandidateId(candidate.getId());

        for(VerificationCandidate v : vList){
            if(v.isVerified()){
                throw new AlreadyVerifiedException("This email has already verified!");
            }
        }

        VerificationCandidate verificationCandidate = createVerificationCandidate(candidate);
        verificationCandidateService.saveVerificationCandidate(verificationCandidate);
        sendEmail(candidate.getEmail(),candidate.getFirstName());
    }

    public List<CandidateResponse> findAllCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();
        return candidateDtoConv.convertToListCandidateResponse(candidates);
    }


    public Candidate findCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId)
                .orElseThrow(() -> new IllegalStateException("Candidate not found!"));
    }
}
