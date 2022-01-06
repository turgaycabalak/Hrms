package com.hrms.hrmsproject.entity.dtos.CandidateDto;

import com.hrms.hrmsproject.entity.users.Candidate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        List<CandidateResponse> candidateResponses = new ArrayList<>();
        candidates.forEach(candidate -> candidateResponses.add(convertToCandidateResp(candidate)));

        return candidateResponses;
    }

}
