package com.project.travelAgency.service;

import com.project.travelAgency.entities.*;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.TourRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TourServiceTest {

    private static final Hotel HOTEL = new Hotel(1L, "Orbis", (short) 3);
    private static final Airport AIRPORT = new Airport(1L, "Okęcie");
    private static final List<Hotel> HOTELS = List.of(HOTEL, HOTEL);
    private static final List<Airport> AIRPORTS = List.of(AIRPORT, AIRPORT);
    private static final List<Tour> TOURS = Arrays.asList(new Tour());
    private static final City CITY = new City(1L, "Dublin", TOURS, TOURS, AIRPORTS, HOTELS);
    private static final City CITY2 = new City(2L, "Moskwa", TOURS, TOURS, AIRPORTS, HOTELS);
    private static final LocalDate departureDate = LocalDate.of(2022, 07, 12);
    private static final LocalDate arrivalDate = LocalDate.of(2022, 07, 19);
    private static final Tour TOUR = new Tour
            ( 2L, (short) 12, departureDate, arrivalDate,  BoardType.BB, 1500, 1100, 34, 8, CITY, CITY2);

    @Mock
    private TourRepo tourRepo;

    @InjectMocks
    private TourService tourService;

    @Test
    void shouldSaveTour() {
        //given
        Mockito.when(tourRepo.save(any())).thenReturn(TOUR);
        //when
        Tour result = tourService.save(TOUR);
        //then
        assertEquals(TOUR, result);
    }

    @Test
    void shouldReturnTourById() {
        //given
        Mockito.when(tourRepo.findById(2L)).thenReturn(Optional.of(TOUR));
        //when
        Tour result = tourService.findById(2L);
        //then
        assertEquals(TOUR, result);
    }

    @Test
    void shouldThrowExceptionWhenIdNotFound() {
        //given
        Mockito.when(tourRepo.findById(1L)).thenReturn(Optional.empty());
        //when & then
        assertThrows(NoIdException.class,
                () -> tourService.findById(1L));
    }
}