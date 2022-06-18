package com.project.travelAgency.service;


import com.project.travelAgency.entities.Hotel;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.HotelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepo hotelRepo;
    private final Hotel hotel = new Hotel();


    public Hotel save(Hotel hotel) {

        return hotelRepo.save(hotel);
    }

    public Hotel findById(Long id) {
        return hotelRepo.findById(id)
                .orElseThrow(()-> new NoIdException("Hotel with given id not found"));
    }

    public Hotel findByName(String name) {
        return hotelRepo.findByName(name).orElse(hotel);
    }

    public List<Hotel> findAll() {
        return hotelRepo.findAll();
    }

    public boolean deleteById(Long id) {
        hotelRepo.delete(findById(id));
        return true;
    }
}
