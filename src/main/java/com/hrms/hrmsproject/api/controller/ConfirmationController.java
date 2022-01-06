package com.hrms.hrmsproject.api.controller;

import com.hrms.hrmsproject.business.ConfirmationServices.ConfirmationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@RequiredArgsConstructor
@RestController
@RequestMapping("confirmations")
@Validated
public class ConfirmationController {

    private final ConfirmationService confirmationService;

    private final String NOT_VALID_ID = "ID should be greater than 0!";


    @GetMapping("confirmemployer")
    public ResponseEntity<?> confirmEmployer(@RequestParam @Min(value = 1,message = NOT_VALID_ID) Long confirmationId,
                                             @RequestParam @Min(value = 1,message = NOT_VALID_ID) Long employeeId){
        confirmationService.confirmById(confirmationId,employeeId);
        return ResponseEntity.ok("Confirmation has successfully done...");
    }



}
