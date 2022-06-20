package com.project.travelAgency.web;


import com.project.travelAgency.entities.Airport;
import com.project.travelAgency.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/travelagency/airport")
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/{id}")
    ResponseEntity<Airport> getById(@PathVariable Long id) {
        return ResponseEntity.ok(airportService.findById(id));
    }

    @GetMapping
    public List<Airport> findAll() {
        return airportService.findAll();
    }


    @PostMapping
    public ResponseEntity<Airport> save(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.save(airport));
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(airportService.deleteById(id));
    }
}
