package com.hrms.hrmsproject.entity.dtos.EmployerDto;

import com.hrms.hrmsproject.entity.dtos.EmployeeDto.EmployeeResponse;
import com.hrms.hrmsproject.entity.users.Employer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        List<EmployerResponse> employerResponses = new ArrayList<>();
        employers.forEach(employer -> employerResponses.add(converToEmployerResp(employer)));

        return employerResponses;
    }


}
