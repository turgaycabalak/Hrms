package com.hrms.hrmsproject.api.controller.UserControllers;

import com.hrms.hrmsproject.business.UserServices.CandidateService;
import com.hrms.hrmsproject.business.UserServices.UserService;
import com.hrms.hrmsproject.entity.dtos.CandidateDto.CandidateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("candidates")
public class CandidateController {

    private final CandidateService candidateService;


    @PostMapping("savecandidate")
    public ResponseEntity<?> saveCandidate(@Valid @RequestBody CandidateReq candidateReq){
        return new ResponseEntity<>(candidateService.saveCandidate(candidateReq),HttpStatus.CREATED);
    }

    @GetMapping("findallcandidates")
    public ResponseEntity<?> findAllCandidates(){
        return ResponseEntity.ok(candidateService.findAllCandidates());
    }




}
