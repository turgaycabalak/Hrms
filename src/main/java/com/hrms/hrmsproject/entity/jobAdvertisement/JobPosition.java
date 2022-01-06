package com.hrms.hrmsproject.entity.jobAdvertisement;

import com.hrms.hrmsproject.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "job_positions")
@NoArgsConstructor
public class JobPosition extends BaseEntity {

    @Column(nullable = false)
    private String positionName;


    public JobPosition(String positionName) {
        this.positionName = positionName;
    }

}
