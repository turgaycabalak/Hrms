package com.hrms.hrmsproject.business.ConfirmationServices;

import com.hrms.hrmsproject.business.UserServices.EmployeeService;
import com.hrms.hrmsproject.core.exceptions.ConfirmationAlreadyConfirmedException;
import com.hrms.hrmsproject.core.exceptions.ConfirmationNotFoundException;
import com.hrms.hrmsproject.dataAccess.ConfirmationRepos.ConfirmationRepo;
import com.hrms.hrmsproject.entity.confirmation.Confirmation;
import com.hrms.hrmsproject.entity.users.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConfirmationService {

    private final ConfirmationRepo confirmationRepo;
    private final EmployeeService employeeService;


    protected Confirmation findConfirmationById(Long confirmationId) {
        return confirmationRepo.findById(confirmationId)
                .orElseThrow(() -> new ConfirmationNotFoundException("Confirmation not found!"));
    }

    public void confirmById(Long confirmationId, Long employeeId) {
        Confirmation confirmation = findConfirmationById(confirmationId);
        Employee employee = employeeService.findEmployeeById(employeeId);

        if(confirmation.isConfirmed() || confirmation.getConfirmedDate() != null){
            throw new ConfirmationAlreadyConfirmedException("This confirmation has already been confirmed!");
        }

        confirmationRepo.updateConfirmation(confirmationId, employee, LocalDateTime.now());

    }




}
