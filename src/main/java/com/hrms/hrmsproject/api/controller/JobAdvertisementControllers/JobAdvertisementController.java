package com.hrms.hrmsproject.api.controller.JobAdvertisementControllers;

import com.hrms.hrmsproject.business.JobAdvertisementService.JobAdvertisementService;
import com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto.JobAdvertisementReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RequiredArgsConstructor
@RestController
@RequestMapping("jobadvertisements")
@Validated
public class JobAdvertisementController {

    private final JobAdvertisementService jobAdvertisementService;

    private final String NOT_VALID_ID = "ID should be greater than 0!";


    @PostMapping("savejobadvertisement")
    public ResponseEntity<?> saveJobAdvertisement(@Valid @RequestBody JobAdvertisementReq jobAdvertisementReq){
        return new ResponseEntity<>(jobAdvertisementService.saveJobAdvertisement(jobAdvertisementReq),HttpStatus.CREATED);
    }

    @GetMapping("disablejobadvertisement")
    public ResponseEntity<?> makeJobAdvertisementPassive(@RequestParam @Min(value = 1,message = NOT_VALID_ID) Long jobAdvertisementId,
                                                         @RequestParam @Min(value = 1,message = NOT_VALID_ID) Long employerId){
        jobAdvertisementService.deactivateJobAdvertisementById(jobAdvertisementId,employerId);
        return ResponseEntity.ok("Job advertisement successfully disabled!");
    }


    //// List<JobAdvertisementResponse> Fazladan 2 select sorgusu atıyor !!!
    @GetMapping("findallactivejobadvertisements")
    public ResponseEntity<?> findAllActiveJobAdvertisements(){
        return ResponseEntity.ok(jobAdvertisementService.findAllActiveJobAdvertisements());
    }

    //// kodlamaio day-8 req-8
    @GetMapping("findallactivejobadvertisements2")
    public ResponseEntity<?> findAllActiveJobAdvertisements2(){
        return ResponseEntity.ok(jobAdvertisementService.findAllActiveJobAdvertisements2());
    }

    //// kodlamaio day-8 req-9
    @GetMapping("findallactivejobadvertisementsordereddate")
    public ResponseEntity<?> findAllActiveJobAdvertisementsOrderByDate(){
        return ResponseEntity.ok(jobAdvertisementService.findAllActiveJobAdvertisementsOrderByDate());
    }

    //// kodlamaio day-8 req-10
    @GetMapping("findallactivejobadvertisementsbycompanyname")
    public ResponseEntity<?> findAllActiveJobAdvertisementsByCompanyName(@RequestParam String companyName){
        return ResponseEntity.ok(jobAdvertisementService.findAllActiveJobAdvertisementsByCompanyName(companyName));
    }





}