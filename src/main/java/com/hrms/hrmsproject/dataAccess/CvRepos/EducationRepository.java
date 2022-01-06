package com.hrms.hrmsproject.dataAccess.CvRepos;

import com.hrms.hrmsproject.entity.cv.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {

}
