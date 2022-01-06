package com.hrms.hrmsproject.dataAccess.ConfirmationRepos;

import com.hrms.hrmsproject.entity.confirmation.ConfirmationEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationEmployerRepo extends JpaRepository<ConfirmationEmployer,Long> {




}
