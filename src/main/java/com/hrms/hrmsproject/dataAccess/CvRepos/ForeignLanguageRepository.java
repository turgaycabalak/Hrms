package com.hrms.hrmsproject.dataAccess.CvRepos;

import com.hrms.hrmsproject.entity.cv.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignLanguageRepository extends JpaRepository<ForeignLanguage,Long> {


}
