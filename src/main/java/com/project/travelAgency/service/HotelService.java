package com.project.travelAgency.service;


import com.project.travelAgency.entities.City;
import com.project.travelAgency.entities.Hotel;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.exception.NoNameException;
import com.project.travelAgency.repository.HotelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepo hotelRepo;
    private final CityService cityService;

    public Hotel save(Hotel hotel) {
        City city = cityService.findByCityName(hotel.getCity().getName());
        hotel.setCity(city);
        return hotelRepo.save(hotel);
    }

    public Hotel findById(Long id) {
        return hotelRepo.findById(id)
                .orElseThrow(()-> new NoIdException("Hotel with given id not found"));
    }

    public Hotel findByCityName(String cityName) {
        return hotelRepo.findHotelByCityName(cityName).orElseThrow(() -> new NoNameException("Hotel not found"));
    }

    public Hotel findByName(String name) {
        return hotelRepo.findByName(name).orElseThrow(() -> new NoNameException("Hotel not found"));
    }

    public List<Hotel> findAll() {
        return hotelRepo.findAll();
    }

    public boolean deleteById(Long id) {
        hotelRepo.delete(findById(id));
        return true;
    }
}
