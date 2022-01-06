package com.hrms.hrmsproject.dataAccess.JobAdvertisementRepos;

import com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto.JobAdvertisementCustomDto;
import com.hrms.hrmsproject.entity.jobAdvertisement.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JobAdvertisementRepo extends JpaRepository<JobAdvertisement,Long> {

    @Transactional
    @Modifying
    @Query("update JobAdvertisement j " +
            "set j.isActive=false " +
            "where j.id= :advertisementId")
    void deactivateJobAdvertisementById(Long advertisementId);

    List<JobAdvertisement> findByIsActive(boolean isActive);

    @Query("select new com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto.JobAdvertisementCustomDto(" +
            "j.id," +
            "j.employer.companyName," +
            "j.jobPosition.positionName," +
            "j.openPositionNumber," +
            "j.createdDate," +
            "j.deadLine) " +
            "from JobAdvertisement j " +
            "where j.isActive= :isActive")
    List<JobAdvertisementCustomDto> findByIsActive2(boolean isActive);

    @Query("select new com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto.JobAdvertisementCustomDto(" +
            "j.id," +
            "j.employer.companyName," +
            "j.jobPosition.positionName," +
            "j.openPositionNumber," +
            "j.createdDate," +
            "j.deadLine) " +
            "from JobAdvertisement j " +
            "where j.isActive= :isActive " +
            "order by j.createdDate ")
    List<JobAdvertisementCustomDto> findByIsActiveOrderedDate(boolean isActive);

    @Query("select new com.hrms.hrmsproject.entity.dtos.JobAdvertisementDto.JobAdvertisementCustomDto(" +
            "j.id," +
            "j.employer.companyName," +
            "j.jobPosition.positionName," +
            "j.openPositionNumber," +
            "j.createdDate," +
            "j.deadLine) " +
            "from JobAdvertisement j " +
            "where lower(j.employer.companyName) " +
            "like %:companyName% and j.isActive= :isActive " +
            "order by j.createdDate")
    List<JobAdvertisementCustomDto> findByIsActiveAndCompanyName(String companyName, boolean isActive);



}
