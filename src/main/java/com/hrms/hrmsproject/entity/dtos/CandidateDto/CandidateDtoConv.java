package com.hrms.hrmsproject.entity.dtos.CandidateDto;

import com.hrms.hrmsproject.entity.users.Candidate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CandidateDtoConv {

    public Candidate convertToCandidate(CandidateReq candidateReq){
        return new Candidate(
                candidateReq.getEmail(),
                candidateReq.getPassword(),
                LocalDateTime.now(),
                candidateReq.getFirstName(),
                candidateReq.getLastName(),
                candidateReq.getIdentityNumber(),
                candidateReq.getBirthYear()
        );
    }

    public CandidateResponse convertToCandidateResp(Candidate candidateWithId){
        return new CandidateResponse(
                candidateWithId.getId(),
                candidateWithId.getFirstName(),
                candidateWithId.getLastName(),
                candidateWithId.getCreatedTime()
        );
    }

    public List<CandidateResponse> convertToListCandidateResponse(List<Candidate> candidates){
        return candidates.stream()
                .map(this::convertToCandidateResp)
                .collect(Collectors.toList());
    }

}
