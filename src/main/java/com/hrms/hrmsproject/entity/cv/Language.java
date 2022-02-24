package com.hrms.hrmsproject.entity.cv;

import com.hrms.hrmsproject.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Languages")
@NoArgsConstructor
public class Language extends BaseEntity {

    @Column(nullable = false)
    private String languageName;

    public Language(String languageName) {
        this.languageName = languageName;
    }
}
