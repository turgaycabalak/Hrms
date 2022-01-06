package com.hrms.hrmsproject.entity.confirmation;

import com.hrms.hrmsproject.entity.users.Employer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "confirmation_employer")
@NoArgsConstructor
public class ConfirmationEmployer extends Confirmation{

    @OneToOne(mappedBy = "confirmationEmployer")
    @JoinColumn(name = "employer_id")
    private Employer employer;



    public ConfirmationEmployer(boolean isConfirmed,
                                Employer employer) {
        super(isConfirmed);
        this.employer = employer;
    }


}
