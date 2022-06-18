package com.project.travelAgency.repository;

import com.project.travelAgency.entities.City;
import com.project.travelAgency.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepo extends JpaRepository<City, Long> {

    List<City> findCitiesByCountry_Name (String name);
   Optional<City> findByName(String n);
   Optional<City> findCityByCountryName (String countryName);
}
