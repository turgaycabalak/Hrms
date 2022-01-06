package com.hrms.hrmsproject.entity.confirmation;

import com.hrms.hrmsproject.entity.BaseEntity;
import com.hrms.hrmsproject.entity.users.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "confirmations")
@NoArgsConstructor
public class Confirmation extends BaseEntity {

    @Column(nullable = false)
    private boolean isConfirmed;

    private LocalDateTime confirmedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;



    public Confirmation(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

}
