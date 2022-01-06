package com.hrms.hrmsproject.dataAccess.VerificationRepos;

import com.hrms.hrmsproject.entity.verification.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface VerificationRepo extends JpaRepository<Verification,Long> {

    Optional<Verification> findByCode(String code);

    @Transactional
    @Modifying
    @Query("update Verification v " +
            "set v.isVerified=true, v.verifiedDate= :verifyDate " +
            "where v.code= :code")
    void updateVerification(String code, LocalDateTime verifyDate);

}
