package com.project.travelAgency.service;

import com.project.travelAgency.entities.City;
import com.project.travelAgency.repository.CityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepo cityRepo;

    public City save(City city) {
        return cityRepo.save(city);
    }

    public List<City> findAll() {
        return cityRepo.findAll();
    }

    public City findById(Long id) {
        try {
            return cityRepo.findById(id).orElseThrow(RuntimeException::new);
        } catch (RuntimeException y) {
            City city=new City();
            city.setName("No ID found");
            return city;
        }
    }


    public boolean deleteById(Long id) {
        cityRepo.delete(findById(id));
        return true;
    }
}
