package com.hrms.hrmsproject.entity.users;

import com.hrms.hrmsproject.entity.confirmation.ConfirmationEmployer;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobAdvertisement;
import com.hrms.hrmsproject.entity.verification.VerificationEmployer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "employers")
@NoArgsConstructor
public class Employer extends User{

    @Column(name = "company_name",nullable = false)
    private String companyName;

    @Column(name = "web_address",nullable = false)
    private String webAddress;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "employer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<VerificationEmployer> verificationEmployers;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private ConfirmationEmployer confirmationEmployer;

    @OneToMany(mappedBy = "employer",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<JobAdvertisement> jobAdvertisements;



    public Employer(String email,
                    String password,
                    LocalDateTime createdTime,
                    String companyName,
                    String webAddress,
                    String phoneNumber) {
        super(email, password, createdTime);
        this.companyName = companyName;
        this.webAddress = webAddress;
        this.phoneNumber = phoneNumber;
    }

}
