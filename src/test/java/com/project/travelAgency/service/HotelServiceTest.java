package com.project.travelAgency.service;

import com.project.travelAgency.entities.Hotel;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.HotelRepo;
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
class HotelServiceTest {


    private static final Hotel HOTEL = new Hotel(1L, "Radisson", (short) 3);
    private static final Hotel HOTEL2 = new Hotel(3L, "Hilton", (short) 3);
    private static final List<Hotel> hotels = List.of(HOTEL, HOTEL2);
    @Mock
    private HotelRepo hotelRepo;


    @InjectMocks
    private HotelService hotelService;

    @Test
    void shouldSaveHotel() {
        //given
        Mockito.when(hotelRepo.save(any())).thenReturn(HOTEL);
        //when
        Hotel result = hotelService.save(HOTEL);
        //then
        assertEquals(HOTEL, result);
    }

    @Test
    void shouldReturnHotelById() {
        //given
        Mockito.when(hotelRepo.getById(any())).thenReturn(HOTEL);
        //when
        Hotel result = hotelService.findById(1L);
        //then
        assertEquals(HOTEL, result);
        assertThat(HOTEL).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 34L})
    void shouldThrowExceptionIfIdNumberDoesNotExist(Long id) {
        Mockito.when(hotelRepo.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoIdException.class,
                () -> hotelService.findById(id),
                "No hotel with given id");
    }

    @Test
    void shouldReturnAllHotels() {
        //given
        Mockito.when(hotelRepo.findAll()).thenReturn(hotels);
        //when
        List<Hotel> result = hotelService.findAll();
        //then
        assertThat(result).isEqualTo(hotels);
    }

    @Test
    void shouldDeleteHotel() {
        //given
        Mockito.when(hotelRepo.findById(1L)).thenReturn(Optional.of(HOTEL));
        //when
        boolean result = hotelService.deleteById(1L);
        //then
        assertTrue(result);
    }

}