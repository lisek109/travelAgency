package com.project.travelAgency.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TourDTO {

    @Id
    private Long id;
    private Short daysNumber;
    private LocalDate departure;
    private LocalDate arrival;
    private Integer finalPrice;
    private Integer adultsSeats;
    private Integer childrenSeats;
    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private City fromCity;

    @ManyToOne
    City toCity;

    public Long getId() {
        return id;
    }

    public Short getDaysNumber() {
        return daysNumber;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public Integer getAdultsSeats() {
        return adultsSeats;
    }

    public Integer getChildrenSeats() {
        return childrenSeats;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public City getFromCity() {
        return fromCity;
    }

    public City getToCity() {
        return toCity;
    }
}
