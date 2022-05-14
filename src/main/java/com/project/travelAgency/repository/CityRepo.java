package com.project.travelAgency.repository;

import com.project.travelAgency.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Long> {
}
