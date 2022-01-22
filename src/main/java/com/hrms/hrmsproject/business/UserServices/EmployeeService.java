package com.hrms.hrmsproject.business.UserServices;

import com.hrms.hrmsproject.core.exceptions.EmployeeNotFoundException;
import com.hrms.hrmsproject.dataAccess.UserRepos.EmployeeRepository;
import com.hrms.hrmsproject.entity.dtos.EmployeeDto.EmployeeDtoConv;
import com.hrms.hrmsproject.entity.dtos.EmployeeDto.EmployeeReq;
import com.hrms.hrmsproject.entity.dtos.EmployeeDto.EmployeeResponse;
import com.hrms.hrmsproject.entity.users.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserService userService;
    private final EmployeeDtoConv employeeDtoConv;


    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id!"));
    }


    public EmployeeResponse saveEmployee(EmployeeReq employeeReq) {
        userService.validateUserEmailAndPassword(
                employeeReq.getPassword(),
                employeeReq.getPasswordRepeat(),
                employeeReq.getEmail()
        );

        Employee employeeWillSaveDb = employeeDtoConv.convertToEmployee(employeeReq);
        Employee employeeSaved = employeeRepository.save(employeeWillSaveDb);

        return employeeDtoConv.convertToEmployeeResp(employeeSaved);
    }


    public List<EmployeeResponse> findAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeDtoConv.convertToListEmployeeResponse(employees);
    }

}
