package com.project.travelAgency.repository;

import com.project.travelAgency.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {
}
