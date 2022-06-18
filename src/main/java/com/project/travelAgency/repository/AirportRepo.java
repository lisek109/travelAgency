package com.project.travelAgency.repository;

import com.project.travelAgency.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AirportRepo extends JpaRepository<Airport, Long> {

Optional<Airport> findAirportByCityName(String cityName);
}
