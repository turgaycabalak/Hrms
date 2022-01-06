package com.hrms.hrmsproject.api.controller.UserControllers;

import com.hrms.hrmsproject.business.UserServices.EmployerService;
import com.hrms.hrmsproject.business.UserServices.UserService;
import com.hrms.hrmsproject.entity.dtos.EmployerDto.EmployerReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("employers")
public class EmployerController {

    private final EmployerService employerService;
    private final UserService userService;


    @PostMapping("saveemployer")
    public ResponseEntity<?> saveEmployer(@Valid @RequestBody EmployerReq employerReq){
        return new ResponseEntity<>(employerService.saveEmployer(employerReq),HttpStatus.CREATED);
    }

    @GetMapping("findallemployers")
    public ResponseEntity<?> findAllEmployers(){
        return ResponseEntity.ok(employerService.findAllEmployers());
    }

}
