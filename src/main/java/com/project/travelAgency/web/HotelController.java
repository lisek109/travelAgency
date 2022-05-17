package com.project.travelAgency.web;

import com.project.travelAgency.entities.Hotel;
import com.project.travelAgency.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable final Hotel hotel) {
        return ResponseEntity.ok(hotelService.save(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> findAll() {
        return ResponseEntity.ok(hotelService.findAll());
    }

    @PostMapping
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.save(hotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(Long id) {
        return ResponseEntity.ok(hotelService.deleteById(id));
    }

}
