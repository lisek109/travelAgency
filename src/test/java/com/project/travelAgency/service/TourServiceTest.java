package com.project.travelAgency.service;

import com.project.travelAgency.entities.BoardType;
import com.project.travelAgency.entities.Tour;
import com.project.travelAgency.exception.NoIdException;
import com.project.travelAgency.repository.TourRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TourServiceTest {

    private static final Tour TOUR = new Tour
            (2L, (short) 12, BoardType.BB, 1500, 1100, 34, 8);

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