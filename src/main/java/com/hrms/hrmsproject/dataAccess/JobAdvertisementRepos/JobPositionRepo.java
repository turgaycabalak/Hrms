package com.hrms.hrmsproject.dataAccess.JobAdvertisementRepos;

import com.hrms.hrmsproject.entity.jobAdvertisement.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobPositionRepo extends JpaRepository<JobPosition,Long> {

    Optional<JobPosition> findByPositionName(String positionName);


}
