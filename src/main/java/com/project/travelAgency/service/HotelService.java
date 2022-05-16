package com.project.travelAgency.service;


import com.project.travelAgency.entities.Hotel;
import com.project.travelAgency.repository.HotelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepo hotelRepo;

    public Hotel save(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    public Hotel findById(Long id) {
        return hotelRepo.findById(id).orElseThrow(() -> new RuntimeException("No hotel with given id"));
    }

    public boolean deleteById(Long id) {
        hotelRepo.deleteById(id);
        return true;
    }
}
