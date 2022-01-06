package com.hrms.hrmsproject.entity.cv;

import com.hrms.hrmsproject.entity.BaseEntity;
import com.hrms.hrmsproject.entity.users.Candidate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "cvs")
@NoArgsConstructor
public class Cv extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    private String photo;
    private String coverLetter;
    private String gitHub;
    private String linkedIn;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
    private List<ForeignLanguage> foreignLanguages;

    @OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
    private List<Skill> skills;


    public Cv(Candidate candidate,
              String photo,
              String coverLetter,
              String gitHub,
              String linkedIn,
              LocalDateTime createdDate) {
        this.candidate = candidate;
        this.photo = photo;
        this.coverLetter = coverLetter;
        this.gitHub = gitHub;
        this.linkedIn = linkedIn;
        this.createdDate = createdDate;
    }

}
