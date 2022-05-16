package com.project.travelAgency.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Short daysNumber;
    @Enumerated(value = EnumType.STRING)
    private BoardType boardType;
    private Integer adultPrice;
    private Integer childPrice;
    private Integer numberOfAdultSeats;
    private Integer numberOfChildSeats;


}
