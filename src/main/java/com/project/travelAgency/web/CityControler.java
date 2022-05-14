package com.project.travelAgency.web;

import com.project.travelAgency.entities.City;
import com.project.travelAgency.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/destination/city")
public class CityControler {

    private final CityService cityService;

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable final Long id) {
        return ResponseEntity.ok(cityService.findById(id));
    }

    @GetMapping
    public List<City> findAll() {
        return cityService.findAll();
    }


    @PostMapping
    public ResponseEntity<City> save(@RequestBody final City city) {
        return ResponseEntity.ok(cityService.save(city));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable final Long id) {
        return ResponseEntity.ok(cityService.deleteById(id));
    }
}
