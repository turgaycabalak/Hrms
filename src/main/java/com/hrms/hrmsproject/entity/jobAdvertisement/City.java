package com.hrms.hrmsproject.entity.jobAdvertisement;

import com.hrms.hrmsproject.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "cities")
@NoArgsConstructor
public class City extends BaseEntity {

    @Column(nullable = false)
    private String cityName;




    public City(String cityName) {
        this.cityName = cityName;
    }

}
