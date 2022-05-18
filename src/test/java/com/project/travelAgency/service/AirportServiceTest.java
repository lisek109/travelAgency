package com.project.travelAgency.service;

import com.project.travelAgency.entities.Airport;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.AirportRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AirportServiceTest {

    private static final Airport AIRPORT = new Airport(1L, "Okecie");
    private static final Airport AIRPORT2 = new Airport(2L, "Heathrow");
    private static final List<Airport> airports = List.of(AIRPORT, AIRPORT2);


    @Mock
    private AirportRepo airportRepo;


    @InjectMocks
    private AirportService airportservice;

    @Test
    void shouldSaveHotel() {
        //given
        Mockito.when(airportRepo.save(any())).thenReturn(AIRPORT);
        //when
        Airport result = airportservice.save(AIRPORT);
        //then
        assertEquals(AIRPORT, result);
    }

    @Test
    void shouldReturnHotelById() {
        //given
        Mockito.when(airportRepo.findById(any())).thenReturn(Optional.of(AIRPORT));
        //when
        Airport result = airportservice.findById(1L);
        //then
        assertEquals(AIRPORT, result);
        assertThat(AIRPORT).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 34L})
    void shouldThrowExceptionIfIdNumberDoesNotExist(Long id) {
        Mockito.when(airportRepo.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoIdException.class,
                () -> airportservice.findById(id),
                "Airport with given id not found");
    }

    @Test
    void shouldReturnAllHotels() {
        //given
        Mockito.when(airportRepo.findAll()).thenReturn(airports);
        //when
        List<Airport> result = airportservice.findAll();
        //then
        assertThat(result).isEqualTo(airports);
    }

    @Test
    void shouldDeleteHotel() {
        //given
        Mockito.when(airportRepo.findById(1L)).thenReturn(Optional.of(AIRPORT));
        //when
        boolean result = airportservice.deleteById(1L);
        //then
        assertTrue(result);
    }

}