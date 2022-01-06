package com.hrms.hrmsproject.dataAccess.UserRepos;

import com.hrms.hrmsproject.entity.dtos.EmployerDto.EmployerResponse;
import com.hrms.hrmsproject.entity.users.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Long> {

    Optional<Employer> findByEmail(String email);

    @Query("select new com.hrms.hrmsproject.entity.dtos.EmployerDto.EmployerResponse(" +
            "e.id," +
            "e.companyName," +
            "e.webAddress," +
            "e.phoneNumber," +
            "e.createdTime) " +
            "from Employer e")
    List<EmployerResponse> findAllEmployerResponses();



}
