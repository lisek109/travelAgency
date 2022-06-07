package com.project.travelAgency.repository;

import com.project.travelAgency.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepo extends JpaRepository<Tour, Long> {

}
