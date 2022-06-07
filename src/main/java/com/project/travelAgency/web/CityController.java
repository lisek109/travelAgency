package com.project.travelAgency.web;

import com.project.travelAgency.entities.City;
import com.project.travelAgency.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/travelagency/city")
public class CityController {

    private final CityService cityService;

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable final Long id) {
        return ResponseEntity.ok(cityService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<City>> findAll() {

        return ResponseEntity.ok(cityService.findAll());
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<City> save(@RequestBody final City city) {

        return ResponseEntity.ok(cityService.save(city));
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable final Long id) {
        return ResponseEntity.ok(cityService.deleteById(id));
    }
}
