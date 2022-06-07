package com.project.travelAgency.service;

import com.project.travelAgency.entities.Airport;
import com.project.travelAgency.exception.NoIdException;
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
        return airportRepo.findById(id)
                .orElseThrow(()-> new NoIdException("Airport with given id not found"));
    }

    public List<Airport> findAll() {
        return airportRepo.findAll();
    }

    public boolean deleteById(Long id) {
         airportRepo.delete(findById(id));
        return true;
    }
}
