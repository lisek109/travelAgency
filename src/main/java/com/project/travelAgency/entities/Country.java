package com.project.travelAgency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Country {

     @Id
     @JsonIgnore
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    
    @Column(unique = true)
    private String name;


    private String continents;

    public Country(String name, String continents) {
        this.continents = continents;
        this.name = name;
    }

}
