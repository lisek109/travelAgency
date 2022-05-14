package com.project.travelAgency.web;

import com.project.travelAgency.entities.Country;
import com.project.travelAgency.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/destination/country")
public class CountryControler {
    private final CountryService countryService;

    @GetMapping("/{id}")
    public ResponseEntity<Country> getById(@PathVariable final Long id) {
        return ResponseEntity.ok(countryService.findById(id));
    }

    @GetMapping
    public List<Country> findAll() {
        return countryService.findAll();
    }


    @PostMapping
    public ResponseEntity<Country> save(@RequestBody final Country country) {
        return ResponseEntity.ok(countryService.save(country));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable final Long id) {
        return ResponseEntity.ok(countryService.deleteById(id));
    }
}
