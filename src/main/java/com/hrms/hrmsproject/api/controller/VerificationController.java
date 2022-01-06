package com.hrms.hrmsproject.api.controller;

import com.hrms.hrmsproject.business.UserServices.CandidateService;
import com.hrms.hrmsproject.business.UserServices.EmployerService;
import com.hrms.hrmsproject.business.VerificationServices.VerificationCandidateService;
import com.hrms.hrmsproject.business.VerificationServices.VerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

@RestController
@RequestMapping("verification")
@RequiredArgsConstructor
@Validated
public class VerificationController {

    private final CandidateService candidateService;
    private final EmployerService employerService;
    private final VerificationService verificationService;

    private final String EMAIL_MESSAGE = "Verification email has been sent.";
    private final String EMAIL_NOT_VALID = "Email should be correct format!";



    @GetMapping("verify")
    public ResponseEntity<?> verifyUser(@RequestParam String code){
        verificationService.verifyCode(code);
        return ResponseEntity.ok("Verification has successfully done...");
    }

    @GetMapping("reproduceverificationcandidate")
    public ResponseEntity<?> reProduceVerificationCandidate(@RequestParam @Email(message = EMAIL_NOT_VALID) String email) {
        candidateService.reProduceVerificationCandidate(email);
        return ResponseEntity.ok(EMAIL_MESSAGE);
    }

    @GetMapping("reproduceverificationemployer")
    public ResponseEntity<?> reProduceVerificationEmployer(@RequestParam @Email(message = EMAIL_NOT_VALID) String email){
        employerService.reProduceVerificationEmployer(email);
        return ResponseEntity.ok(EMAIL_MESSAGE);
    }



}
