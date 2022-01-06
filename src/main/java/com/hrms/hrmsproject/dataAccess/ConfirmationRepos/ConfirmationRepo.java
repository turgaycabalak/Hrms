package com.hrms.hrmsproject.dataAccess.ConfirmationRepos;

import com.hrms.hrmsproject.entity.confirmation.Confirmation;
import com.hrms.hrmsproject.entity.users.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface ConfirmationRepo extends JpaRepository<Confirmation,Long> {

    @Transactional
    @Modifying
    @Query("update Confirmation c " +
            "set c.isConfirmed=true , c.employee= :employee , c.confirmedDate= :confirmedDate " +
            "where c.id= :confirmationId")
    void updateConfirmation(Long confirmationId, Employee employee, LocalDateTime confirmedDate);




}
