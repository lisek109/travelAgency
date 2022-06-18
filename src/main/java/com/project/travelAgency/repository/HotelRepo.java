package com.project.travelAgency.repository;

import com.project.travelAgency.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepo extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findByName(String hotelName);
    Optional<Hotel> findHotelByCityName(String cityName);
}
