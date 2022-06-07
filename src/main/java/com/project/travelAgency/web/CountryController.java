package com.project.travelAgency.web;

import com.project.travelAgency.entities.Continents;
import com.project.travelAgency.entities.Country;
import com.project.travelAgency.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/destination/country")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/{id}")
    public ResponseEntity<Country> getById(@PathVariable final Long id) {
        return ResponseEntity.ok(countryService.findById(id));
    }
    @GetMapping("/find/{continents}")
    public ResponseEntity<List<Country>> findCountriesByContinent(@PathVariable final Continents continents) {
        return ResponseEntity.ok(countryService.findCountriesByContinent(continents));
    }
    @GetMapping
    public ResponseEntity<List<Country>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
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
