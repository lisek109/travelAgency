package com.project.travelAgency.service;

import com.project.travelAgency.entities.Airport;
import com.project.travelAgency.repository.AirportRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepo airportRepo;

    public Airport save(Airport airport) {
        return airportRepo.save(airport);
    }

    public Airport findById(Long id) {
        try {
         return airportRepo.findById(id).orElseThrow(RuntimeException::new);
        } catch (RuntimeException r) {
            Airport airport = new Airport();
            airport.setName("No airport with given id");
            return airport;
        }
    }

    public List<Airport> findAll() {
        return airportRepo.findAll();
    }

    public boolean deleteById(Long id) {
         airportRepo.deleteById(id);
        return true;
    }
}
