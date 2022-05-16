package com.project.travelAgency.service;

import com.project.travelAgency.entities.City;
import com.project.travelAgency.entities.Country;
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
        try {
            return countryRepo.findById(id).orElseThrow(RuntimeException::new);
        } catch (RuntimeException y) {
            Country country = new Country();
            country.setName("No ID found");
            return country;
        }
    }

    public boolean deleteById(Long id) {
        countryRepo.delete(findById(id));
        return true;
    }
}

