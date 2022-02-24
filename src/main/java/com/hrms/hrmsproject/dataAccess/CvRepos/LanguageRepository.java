package com.hrms.hrmsproject.dataAccess.CvRepos;

import com.hrms.hrmsproject.entity.cv.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    Optional<Language> findByLanguageName(String languageName);
}
