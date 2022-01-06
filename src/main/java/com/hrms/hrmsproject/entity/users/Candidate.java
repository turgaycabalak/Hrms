package com.hrms.hrmsproject.entity.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.verification.VerificationCandidate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "candidates")
@NoArgsConstructor
public class Candidate extends User{

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;

    @Column(name = "identity_number",length = 11,unique = true)
    private String identityNumber;

    @Column(name = "birth_year")
    private int birthYear;

    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<VerificationCandidate> verificationCandidates;

    @OneToMany(mappedBy = "candidate",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Cv> cvs;




    public Candidate(String email,
                     String password,
                     LocalDateTime createdTime,
                     String firstName,
                     String lastName,
                     String identityNumber,
                     int birthYear) {
        super(email, password, createdTime);
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.birthYear = birthYear;
    }


}
