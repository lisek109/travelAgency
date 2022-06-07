package com.project.travelAgency.service;

import com.project.travelAgency.entities.*;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.CountryRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.project.travelAgency.entities.Continents.EUROPE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {
    private static final Hotel HOTEL = new Hotel(1L, "Orbis", (short) 3);
    private static final Airport AIRPORT = new Airport(1L, "Okęcie");
    private static final List<Hotel> HOTELS = List.of(HOTEL, HOTEL);
    private static final List<Airport> AIRPORTS = List.of(AIRPORT, AIRPORT);
    private static List<Tour> TOURS = Arrays.asList(new Tour());
    private static final City CITY = new City(1L, "Gdańsk",  AIRPORTS, HOTELS);
    private static final Country COUNTRY = new Country(1L, "Poland", EUROPE, List.of(CITY, CITY));
    private static final List<Country> COUNTRIES = List.of(COUNTRY, COUNTRY);

    @Mock
    private CountryRepo countryRepo;

    @InjectMocks
    private CountryService countryService;


    @Test
    void shouldSaveCountry() {
        //given
        Mockito.when(countryRepo.save(any())).thenReturn(COUNTRY);
        //when
        Country result = countryService.save(any());
        //then
        assertEquals(COUNTRY, result);
        //Drugi sposób na .save, też nie wiem czy dobrze
    }

    @Test
    void shouldFindAll() {
        //given
        Mockito.when(countryRepo.findAll()).thenReturn(COUNTRIES);
        //when
        List<Country> result = countryService.findAll();
        //then
        assertEquals(COUNTRIES, result);

    }

    @Test
    void shouldFindById() {
        //given
        Mockito.when(countryRepo.findById(1L)).thenReturn(Optional.of(COUNTRY));
        //when
        Country result = countryService.findById(1L);
        //then
        assertEquals(COUNTRY, result);

    }

    @Test
    void deleteById() {
        //given
        Mockito.when(countryRepo.findById(1L)).thenReturn(Optional.of(COUNTRY));
        //when
        boolean result = countryService.deleteById(1L);
        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 5L, 7L})
    void shouldThrowExceptionIfIdNumberDoesNotExist(Long id) {
        //given
        Mockito.when(countryRepo.findById(id)).thenReturn(Optional.empty());
        //when & then
        assertThrows(NoIdException.class,
                () -> countryService.findById(id));
    }
}