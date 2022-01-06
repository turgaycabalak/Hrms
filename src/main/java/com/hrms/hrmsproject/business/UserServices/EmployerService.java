package com.hrms.hrmsproject.business.UserServices;

import com.hrms.hrmsproject.business.VerificationServices.VerificationEmployerService;
import com.hrms.hrmsproject.core.emailSender.EmailBuilder;
import com.hrms.hrmsproject.core.emailSender.EmailSender;
import com.hrms.hrmsproject.core.exceptions.*;
import com.hrms.hrmsproject.dataAccess.UserRepos.EmployerRepository;
import com.hrms.hrmsproject.entity.confirmation.ConfirmationEmployer;
import com.hrms.hrmsproject.entity.dtos.EmployerDto.EmployerDtoConv;
import com.hrms.hrmsproject.entity.dtos.EmployerDto.EmployerReq;
import com.hrms.hrmsproject.entity.dtos.EmployerDto.EmployerResponse;
import com.hrms.hrmsproject.entity.users.Employer;
import com.hrms.hrmsproject.entity.verification.VerificationEmployer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final VerificationEmployerService verificationEmployerService;
    private final UserService userService;
    private final EmployerDtoConv employerDtoConv;
    private final EmailSender emailSender;
    private final EmailBuilder emailBuilder;
    private String code;


    protected VerificationEmployer createVerificationEmployer(Employer employerWillSaveDb){
        code = UUID.randomUUID().toString();
        return new VerificationEmployer(
                code,
                false,
                LocalDateTime.now().plusMinutes(15),
                employerWillSaveDb
        );
    }

    protected void sendEmail(String email,String companyName){
        String verificationLink = "http://localhost:8080/verification/verify?code="+code;
        emailSender.send(email,emailBuilder.buildEmail(companyName,verificationLink));
    }

    protected ConfirmationEmployer createConfirmationEmployer(Employer employerWillSaveDb) {
        return new ConfirmationEmployer(
                false,
                employerWillSaveDb
        );
    }


    public EmployerResponse saveEmployer(EmployerReq employerReq) {
        userService.validateUserEmailAndPassword(
                employerReq.getPassword(),
                employerReq.getPasswordRepeat(),
                employerReq.getEmail()
        );
        String[] emailSplit = employerReq.getEmail().split("@");
        String[] webSplit = employerReq.getWebsite().split("www.");
        if(!emailSplit[1].equals(webSplit[1])){
            throw new WebsiteAndEmailNotMatchingException("The extension of the mail and web address is not the same!");
        }

        Employer employerWillSaveDb = employerDtoConv.convertToEmployer(employerReq);

        VerificationEmployer verificationEmployer = createVerificationEmployer(employerWillSaveDb);
        employerWillSaveDb.setVerificationEmployers(List.of(verificationEmployer));

        ConfirmationEmployer confirmationEmployer = createConfirmationEmployer(employerWillSaveDb);
        employerWillSaveDb.setConfirmationEmployer(confirmationEmployer);

        Employer employerSaved = employerRepository.save(employerWillSaveDb);
/////////////
        sendEmail(employerReq.getEmail(),employerReq.getCompanyName());
/////////////
        return employerDtoConv.converToEmployerResp(employerSaved);
    }

    private Employer findEmployerByEmail(String email) {
        return employerRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Email doesn't exist!"));
    }

    public void reProduceVerificationEmployer(String email) {
        Employer employer = findEmployerByEmail(email);
        List<VerificationEmployer> vList = verificationEmployerService.findAllByEmployerId(employer.getId());

        for (VerificationEmployer v : vList){
            if (v.isVerified()){
                throw new AlreadyVerifiedException("This email has already verified!");
            }
        }

        VerificationEmployer verificationEmployer = createVerificationEmployer(employer);
        verificationEmployerService.saveVerificationEmployer(verificationEmployer);
        sendEmail(employer.getEmail(),employer.getCompanyName());
    }

    public List<EmployerResponse> findAllEmployers() {
        List<Employer> employers = employerRepository.findAll();
        return employerDtoConv.convertToListEmployerResponse(employers);
//        return employerRepository.findAllEmployerResponses();
    }


    public Employer findEmployerById(Long employerId) {
        return employerRepository.findById(employerId)
                .orElseThrow(() -> new EmployerNotFoundException("Employer not found!"));
    }


}
