package com.hrms.hrmsproject.entity.dtos.CityDto;

import com.hrms.hrmsproject.entity.jobAdvertisement.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityDtoConv {

    public CityResponse convertToCityResponse(City city){
        return new CityResponse(
                city.getId(),
                city.getCityName()
        );
    }

    public List<CityResponse> convertToListCityResponse(List<City> cities){
        List<CityResponse> cityResponses = new ArrayList<>();
        cities.forEach(city -> cityResponses.add(convertToCityResponse(city)));

        return cityResponses;
    }

}
