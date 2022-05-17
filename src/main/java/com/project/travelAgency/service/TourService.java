package com.project.travelAgency.service;

import com.project.travelAgency.entities.Tour;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.TourRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepo tourRepo;

    public Tour save(Tour tour) {
        return tourRepo.save(tour);
    }

    public Tour findById(Long id) {
        return tourRepo.findById(id)
                .orElseThrow(()-> new NoIdException("No tour with given id found"));
    }

    public List<Tour> findAll() {
        return tourRepo.findAll();
    }

    public boolean deleteById(Long id) {
        tourRepo.delete(findById(id));
        return true;
    }


}
