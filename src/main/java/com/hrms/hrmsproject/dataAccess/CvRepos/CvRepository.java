package com.hrms.hrmsproject.dataAccess.CvRepos;

import com.hrms.hrmsproject.entity.cv.Cv;
import com.hrms.hrmsproject.entity.dtos.CvDto.CvResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvRepository extends JpaRepository<Cv,Long> {

    List<Cv> findByCandidateId(Long candidateId);


//    @Query("select new com.hrms.hrmsproject.entity.dtos.CvDto.CvResponse(" +
//            "cv.id," +
//            "cv.candidate.firstName," +
//            "cv.candidate.lastName," +
//            "cv.photo," +
//            "cv.coverLetter," +
//            "cv.gitHub," +
//            "cv.linkedIn," +
//            "cv.createdDate," +
//            "cv.updatedDate) " +
//            "from Cv cv " +
//            "inner join Education e on e.cv.id = cv.id " +
//            "inner join JobExperience j on j.cv.id = cv.id " +
//            "inner join ForeignLanguage f on f.cv.id = cv.id " +
//            "inner join Skill s on s.cv.id = cv.id " +
//            "where cv.candidate.id = :candidateId")
//    List<CvResponse> findCvsByCandidateId(Long candidateId);

}
