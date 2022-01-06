package com.hrms.hrmsproject.dataAccess.CvRepos;

import com.hrms.hrmsproject.entity.cv.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobExperienceRepository extends JpaRepository<JobExperience,Long> {


}
