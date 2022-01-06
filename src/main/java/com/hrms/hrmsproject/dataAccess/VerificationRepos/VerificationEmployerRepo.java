package com.hrms.hrmsproject.dataAccess.VerificationRepos;

import com.hrms.hrmsproject.entity.verification.VerificationEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerificationEmployerRepo extends JpaRepository<VerificationEmployer,Long> {

    Optional<List<VerificationEmployer>> findAllByEmployerId(Long id);



}
