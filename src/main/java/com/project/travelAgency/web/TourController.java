package com.project.travelAgency.web;


import com.project.travelAgency.entities.Tour;
import com.project.travelAgency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tour")
public class TourController {

    private final TourService tourService;

    @GetMapping("/city/departure/{city}")
    public ResponseEntity <List<Tour>> getByDepartureCity(@PathVariable final String city) {
        return ResponseEntity.ok(tourService.findByFromCityName(city));
    }

    @GetMapping("/city/arrival/{city}")
    public ResponseEntity <List<Tour>> getByArrivalCity(@PathVariable final String city) {
        return ResponseEntity.ok(tourService.findByToCityName(city));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getById(@PathVariable final Long id) {
        return ResponseEntity.ok(tourService.findById(id));
    }

    @GetMapping
    public ResponseEntity <List<Tour>> findALl() {
        return ResponseEntity.ok(tourService.findAll());
    }



    @PostMapping
    public ResponseEntity<Tour> save(@RequestBody Tour tour) {
        return ResponseEntity.ok(tourService.save(tour));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable final Long id) {
        return ResponseEntity.ok(tourService.deleteById(id));
    }
}
