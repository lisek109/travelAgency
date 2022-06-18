package com.project.travelAgency.service;

import com.project.travelAgency.entities.City;
import com.project.travelAgency.entities.Continents;
import com.project.travelAgency.entities.Country;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.exception.NoNameException;
import com.project.travelAgency.repository.CountryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepo countryRepo;

    public Country save(Country country) {
        return countryRepo.save(country);
    }

    public List<Country> findAll() {
        return countryRepo.findAll();
    }

    public Country findById(Long id) {
            return countryRepo.findById(id)
                    .orElseThrow(()-> new NoIdException("Country with given id not found"));
    }

    public Country findByName(String name) {
        return countryRepo.findByName(name).orElseThrow(() -> new NoNameException("Country with given name not found"));
    }

    public List<Country> findCountriesByContinent (Continents continents){
        return countryRepo.findCountriesByContinentsIs(continents);
    }

    public boolean deleteById(Long id) {
        countryRepo.delete(findById(id));
        return true;
    }
}

