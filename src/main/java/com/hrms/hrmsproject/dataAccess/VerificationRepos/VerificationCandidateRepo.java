package com.hrms.hrmsproject.dataAccess.VerificationRepos;

import com.hrms.hrmsproject.entity.verification.VerificationCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerificationCandidateRepo extends JpaRepository<VerificationCandidate,Long> {

    Optional<List<VerificationCandidate>> findAllByCandidateId(Long id);

}
