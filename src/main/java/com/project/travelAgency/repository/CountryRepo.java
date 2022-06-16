package com.project.travelAgency.repository;

import com.project.travelAgency.entities.Continents;
import com.project.travelAgency.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EnumType;
import java.util.List;
import java.util.Optional;

public interface CountryRepo extends JpaRepository<Country, Long> {

    List<Country> findCountriesByContinentsIs(Continents continents);
    Optional<Country> findByName(String name);

}