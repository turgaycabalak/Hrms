package com.hrms.hrmsproject.entity.dtos.EmployerDto;

import com.hrms.hrmsproject.entity.users.Employer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployerDtoConv {

    public Employer convertToEmployer(EmployerReq employerReq){
        return new Employer(
                employerReq.getEmail(),
                employerReq.getPassword(),
                LocalDateTime.now(),
                employerReq.getCompanyName(),
                employerReq.getWebsite(),
                employerReq.getPhoneNumber()
        );
    }

    public EmployerResponse converToEmployerResp(Employer employerWithId){
        return new EmployerResponse(
                employerWithId.getId(),
                employerWithId.getCompanyName(),
                employerWithId.getWebAddress(),
                employerWithId.getPhoneNumber(),
                employerWithId.getCreatedTime()
        );
    }

    public List<EmployerResponse> convertToListEmployerResponse(List<Employer> employers){
        return employers.stream()
                .map(this::converToEmployerResp)
                .collect(Collectors.toList());
    }


}
