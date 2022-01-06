package com.hrms.hrmsproject.api.controller.UserControllers;

import com.hrms.hrmsproject.business.UserServices.EmployeeService;
import com.hrms.hrmsproject.entity.dtos.EmployeeDto.EmployeeReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("saveemployee")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeReq employeeReq){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeReq), HttpStatus.CREATED);
    }

    @GetMapping("findallemployee")
    public ResponseEntity<?> findAllEmployee(){
        return ResponseEntity.ok(employeeService.findAllEmployee());
    }



}
