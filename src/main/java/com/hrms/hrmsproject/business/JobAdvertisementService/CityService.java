package com.hrms.hrmsproject.business.JobAdvertisementService;

import com.hrms.hrmsproject.core.exceptions.CityAlreadyExistException;
import com.hrms.hrmsproject.core.exceptions.CityNotFoundException;
import com.hrms.hrmsproject.dataAccess.JobAdvertisementRepos.CityRepository;
import com.hrms.hrmsproject.entity.dtos.CityDto.CityDtoConv;
import com.hrms.hrmsproject.entity.dtos.CityDto.CityResponse;
import com.hrms.hrmsproject.entity.jobAdvertisement.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityDtoConv cityDtoConv;


    public CityResponse saveCity(String cityName) {
        if (cityRepository.findByCityName(cityName.toUpperCase()).isPresent()){
            throw new CityAlreadyExistException("City name already exist!");
        }

        City savedCity = cityRepository.save(new City(cityName.toUpperCase()));
        return cityDtoConv.convertToCityResponse(savedCity);
    }

    public List<CityResponse> findAllCities(){
        List<City> cities = cityRepository.findAll();

        return cityDtoConv.convertToListCityResponse(cities);
    }


    public City findCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new CityNotFoundException("City not found!"));
    }


}
