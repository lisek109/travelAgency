package com.project.travelAgency.entities;


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
    private Long id;
    private Short daysNumber;
    private LocalDate departure;
    private LocalDate arrival;
  //  @Enumerated(value = EnumType.STRING)
  //  private BoardType boardType;
    private Integer adultPrice;
    private Integer childPrice;
    private Integer numberOfAdultSeatsLeft;
    private Integer numberOfChildSeatsLeft;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private City fromCity; //warszawa

   @ManyToOne
   City toCity; // paryz, tokio

}
