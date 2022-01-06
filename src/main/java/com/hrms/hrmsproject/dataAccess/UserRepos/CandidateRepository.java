package com.hrms.hrmsproject.dataAccess.UserRepos;

import com.hrms.hrmsproject.entity.users.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {

    Optional<Candidate> findByIdentityNumber(String identityNumber);

    Optional<Candidate> findByEmail(String email);

}
