package com.project.travelAgency.service;

import com.project.travelAgency.entities.City;
import com.project.travelAgency.entities.Country;
import com.project.travelAgency.entities.Hotel;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.exception.NoNameException;
import com.project.travelAgency.repository.CityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepo cityRepo;
    private final CountryService countryService;

    public City save(City city) {
        Country country = countryService.findByName(city.getCountry().getName());
        city.setCountry(country);
        return cityRepo.save(city);
    }

    public List<City> findAll() {
        return cityRepo.findAll();
    }

    public City findById(Long id) {
        return cityRepo.findById(id)
                .orElseThrow(()-> new NoIdException("City with given id not found"));
    }


    public List<City> findCitiesByCountryName(String countryName) {
        return cityRepo.findCitiesByCountry_Name(countryName);
    }

    public City findByCityName(String cityName) {
        return cityRepo.findByName(cityName).orElseThrow(() -> new NoNameException("City not found"));
    }
    public boolean deleteById(Long id) {
        cityRepo.delete(findById(id));
        return true;
    }
}
