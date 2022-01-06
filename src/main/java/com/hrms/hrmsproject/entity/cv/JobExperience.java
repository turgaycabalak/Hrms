package com.hrms.hrmsproject.entity.cv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrmsproject.entity.BaseEntity;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobPosition;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "job_experiences")
@NoArgsConstructor
public class JobExperience extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    @JsonIgnore
    private Cv cv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdDate;


    public JobExperience(Cv cv,
                         String companyName,
                         JobPosition jobPosition,
                         LocalDate startDate,
                         LocalDate endDate,
                         LocalDateTime createdDate) {
        this.cv = cv;
        this.companyName = companyName;
        this.jobPosition = jobPosition;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdDate = createdDate;
    }
}
