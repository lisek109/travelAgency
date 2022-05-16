package com.project.travelAgency.repository;

import com.project.travelAgency.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport, Long> {
}
