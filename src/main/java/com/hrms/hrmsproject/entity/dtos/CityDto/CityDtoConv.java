package com.hrms.hrmsproject.entity.dtos.CityDto;

import com.hrms.hrmsproject.entity.jobAdvertisement.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityDtoConv {

    public CityResponse convertToCityResponse(City city){
        return new CityResponse(
                city.getId(),
                city.getCityName()
        );
    }

    public List<CityResponse> convertToListCityResponse(List<City> cities){
        return cities.stream()
                .map(this::convertToCityResponse)
                .collect(Collectors.toList());
    }

}
