package com.hrms.hrmsproject.dataAccess.VerificationRepos;

import com.hrms.hrmsproject.entity.verification.VerificationEmployer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VerificationEmployerRepoTest {

    @Autowired
    private VerificationEmployerRepo verificationEmployerRepo;


    @Test
    public void findAllVerificationEmployerByEmployerId(){
        List<VerificationEmployer> vList = verificationEmployerRepo.findAllByEmployerId(1L)
                .orElseThrow(() -> new IllegalStateException("Any verification for candidate not found for this id!"));

//        for (VerificationEmployer v : vList){
//            int i=1;
//            System.out.println(i);
//            i++;
//        }
    }


}