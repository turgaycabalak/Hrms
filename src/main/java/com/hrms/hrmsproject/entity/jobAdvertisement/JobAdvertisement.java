package com.hrms.hrmsproject.entity.jobAdvertisement;

import com.hrms.hrmsproject.entity.BaseEntity;
import com.hrms.hrmsproject.entity.users.Employer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "job_advertisements")
@NoArgsConstructor
public class JobAdvertisement extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;// updatable insertable false olarak yapilabilir

    @Column(nullable = false)
    private String jobDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;// updatable insertable false olarak yapilabilir

    private int minSalary;
    private int maxSalary;

    @Column(nullable = false)
    private int openPositionNumber;

    private LocalDate deadLine;

    @Column(nullable = false)
    private LocalDate createdDate;

    @Column(nullable = false)
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private Employer employer;// updatable insertable false olarak yapilabilir


    public JobAdvertisement(JobPosition jobPosition,
                            String jobDescription,
                            City city,
                            int minSalary,
                            int maxSalary,
                            int openPositionNumber,
                            LocalDate deadLine,
                            LocalDate createdDate,
                            boolean isActive,
                            Employer employer) {
        this.jobPosition = jobPosition;
        this.jobDescription = jobDescription;
        this.city = city;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.openPositionNumber = openPositionNumber;
        this.deadLine = deadLine;
        this.createdDate = createdDate;
        this.isActive = isActive;
        this.employer = employer;
    }

}
