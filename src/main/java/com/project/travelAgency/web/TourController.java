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

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getById(@PathVariable final Long id) {
        return ResponseEntity.ok(tourService.findById(id));
    }

    @GetMapping
    public List<Tour> findALl() {
        return tourService.findAll();
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
