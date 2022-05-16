package com.project.travelAgency.service;

import com.project.travelAgency.entities.Airport;
import com.project.travelAgency.entities.City;
import com.project.travelAgency.entities.Hotel;
import com.project.travelAgency.entities.Tour;
import com.project.travelAgency.repository.CityRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {
    private static final Hotel HOTEL = new Hotel(1L, "Orbis", (short) 3);
    private static final Airport AIRPORT = new Airport(1L, "Okęcie");
    private static final List<Hotel> HOTELS =List.of(HOTEL,HOTEL);
    private static final List<Airport> AIRPORTS =List.of(AIRPORT,AIRPORT);
    private static final List<Tour> TOURS = Arrays.asList(new Tour());
    private static final City CITY = new City(1L, "Dublin", TOURS, TOURS,AIRPORTS, HOTELS);
    private static final List<City> CITIES = List.of(CITY, CITY);


    @Mock
    private CityRepo cityRepo;

    @InjectMocks
    private CityService cityService;


    @Test
    void shouldSaveObjectCity() {
        //given
        Mockito.when(cityRepo.save(any())).thenReturn(CITY);
        //when
        City result = cityService.save(CITY);
        //then
        assertEquals(CITY, result);
        //Czy to nie jest masło maślane?
    }

    @Test
    void shouldFindAll() {
        //given
        Mockito.when(cityRepo.findAll()).thenReturn(CITIES);
        //when
        List<City> resultList = cityService.findAll();
        //then
        assertEquals(CITIES, resultList);
    }

    @Test
    void shouldFindById() {
        //given
        Mockito.when(cityRepo.findById(1L)).thenReturn(Optional.of(CITY));
        //when
        City result = cityService.findById(1L);
        //then
        assertEquals(CITY, result);
    }

    @Test
    void shoulDdeleteById() {
        //given
        Mockito.when(cityRepo.findById(1L)).thenReturn(Optional.of(CITY));
        //when
        boolean result = cityService.deleteById(1L);
        //then
        assertTrue(result);
        //Nie jestem pewien czy to jest dobrze
    }
}