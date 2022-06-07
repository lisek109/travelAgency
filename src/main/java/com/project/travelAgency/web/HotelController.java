package com.project.travelAgency.web;

import com.project.travelAgency.entities.Hotel;
import com.project.travelAgency.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/travelagency/hotel")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable final Long id) {
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> findAll() {
        return ResponseEntity.ok(hotelService.findAll());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Hotel> findByName(@PathVariable final String name) {
        return ResponseEntity.ok(hotelService.findByName(name));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.save(hotel));
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(Long id) {
        return ResponseEntity.ok(hotelService.deleteById(id));
    }

}
