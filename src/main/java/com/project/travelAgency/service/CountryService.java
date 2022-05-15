package com.project.travelAgency.service;

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
        return countryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Country not exist with id: " + id));
    }
    public boolean deleteById(Long id) {
        countryRepo.delete(findById(id));
        return true;
    }
}


