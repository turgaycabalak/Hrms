package com.hrms.hrmsproject.dataAccess.JobAdvertisementRepos;

import com.hrms.hrmsproject.entity.jobAdvertisement.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    Optional<City> findByCityName(String cityName);

}
