package com.project.travelAgency.repository;

import com.project.travelAgency.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepo extends JpaRepository<City, Long> {

   // List<City> findCitiesByCountry_Name (String name);
}
