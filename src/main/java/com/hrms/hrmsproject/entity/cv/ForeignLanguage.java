package com.hrms.hrmsproject.entity.cv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrmsproject.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "foreign_languages")
@NoArgsConstructor
public class ForeignLanguage extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "cv_id")
    @JsonIgnore
    private Cv cv;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private Language language;

    private int level;
    private LocalDateTime createdDate;


    public ForeignLanguage(Cv cv,
                           Language language,
                           int level,
                           LocalDateTime createdDate) {
        this.cv = cv;
        this.language = language;
        this.level = level;
        this.createdDate = createdDate;
    }
}
