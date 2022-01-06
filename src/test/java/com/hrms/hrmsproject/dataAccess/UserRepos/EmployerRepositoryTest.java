package com.hrms.hrmsproject.dataAccess.UserRepos;

import com.hrms.hrmsproject.entity.users.Employer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployerRepositoryTest {

    @Autowired
    private EmployerRepository employerRepository;


    @Test
    public void findAllEmployers(){
        List<Employer> employers = employerRepository.findAll();

        for (Employer e : employers){
            System.out.println(e.getCompanyName());
        }
    }

    @Test
    public void deleteEmployerById(){
        employerRepository.deleteById(1L);
    }



}