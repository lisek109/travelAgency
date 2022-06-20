package com.project.travelAgency.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String nameTour;
    private Short daysNumber;
    private LocalDate departure;
    private LocalDate arrival;
    private Integer adultPrice;
    private Integer childPrice;
    private Integer numberOfAdultSeatsLeft;
    private Integer numberOfChildSeatsLeft;

    @OneToOne
    private Airport arrivalAirport;
    @OneToOne
    private Airport departureAirport;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private City fromCity;

   @ManyToOne
   City toCity;

}
