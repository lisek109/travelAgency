package com.project.travelAgency.service;

import com.project.travelAgency.entities.Tour;
import com.project.travelAgency.entities.TourDTO;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.TourRepo;
import com.project.travelAgency.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepo tourRepo;
    private final UserRepo userRepo;

    public Tour save(Tour tour) {
        return tourRepo.save(tour);
    }

    public Tour findById(Long id) {
        return tourRepo.findById(id)
                .orElseThrow(()-> new NoIdException("Tour with given id not found"));
    }

    public List<Tour> findAll() {
        return tourRepo.findAll();
    }

    public boolean deleteById(Long id) {
        tourRepo.delete(findById(id));
        return true;
    }

    public List<Tour> findByToCityName(String cityName) {
        if (tourRepo.findToursByToCity_Name(cityName).isEmpty()) {
            return new ArrayList<>();
        }else {
            return tourRepo.findToursByToCity_Name(cityName);
        }
    }


    public List<Tour> findByFromCityName(String cityName) {
        if (tourRepo.findToursByFromCity_Name(cityName).isEmpty()) {
            return new ArrayList<>();
        }else {
            return tourRepo.findToursByFromCity_Name(cityName);
        }
    }


    public void buyTour(Long id,Integer adultSeats, Integer childrenSeats) {
        Tour tour = findById(id);
        if (adultSeats > 0) {
            Integer seatsLeft = tour.getNumberOfAdultSeatsLeft() - adultSeats;
            tour.setNumberOfAdultSeatsLeft(seatsLeft);
        }

        if (childrenSeats > 0) {
            Integer seatsLeft = tour.getNumberOfChildSeatsLeft() - childrenSeats;
            tour.setNumberOfChildSeatsLeft(seatsLeft);
        }
        save(tour);

        Integer price = tour.getAdultPrice() * adultSeats;

        TourDTO tourDTO = new TourDTO(tour.getId(), tour.getDaysNumber(), tour.getDeparture()
        , tour.getArrival(), price, adultSeats, childrenSeats, tour.getHotel(), tour.getFromCity()
        , tour.getToCity());



    }
}
