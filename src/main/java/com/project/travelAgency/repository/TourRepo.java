package com.project.travelAgency.repository;

import com.project.travelAgency.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TourRepo extends JpaRepository<Tour, Long> {

 List<Tour> findToursByFromCity_Name(String cityName);
 List<Tour> findToursByToCity_Name(String cityName);

}
